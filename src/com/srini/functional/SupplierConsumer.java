package com.srini.functional;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class SupplierConsumer<T> extends Thread {

	  private Supplier<T> supplier;
	  private Consumer<T> consumer;
	  private static boolean shouldRun = true;

	  public SupplierConsumer(Supplier<T> supplier, Consumer<T> consumer) {
	    this.supplier = supplier;
	    this.consumer = consumer;
	  }

	  @Override
	  public void run() {
	    while (shouldRun) {
	      T item = supplier.get();
	      consumer.accept(item);
	    }
	  }

	  
	  public static void main(String[] args) throws InterruptedException {
		  BlockingQueue<Person> usersQueue = new LinkedBlockingQueue<Person>();

		  Supplier<Person> userSupplier = new Supplier<Person>() {
		    @Override
		    public Person get() {
		      try {
		        return usersQueue.take();
		      } catch (InterruptedException e) {
		        throw new RuntimeException(e);
		      }
		    }
		  };

		  Consumer<Person> userConsumer = new Consumer<Person>() {
		    @Override
		    public void accept(Person user) {
		      System.out.println("Processing user " + user.getName());
		    }
		  };

		  new SupplierConsumer<>(userSupplier, userConsumer).start();

		  for (int i = 0; i < 10; i++) {
		    usersQueue.put(new Person("srini", 16));
		  }
		  Thread.sleep(3);
		  shouldRun = false;
		  System.out.println("done");
	}
}