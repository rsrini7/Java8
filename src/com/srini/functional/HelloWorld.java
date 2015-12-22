package com.srini.functional;

import java.util.function.*;
public class HelloWorld{

    public static void main(String []args){
        new HelloWorld().test();
     }
     
     private  void test(){
        Consumer<String> consumer = this::printNames;
 
 
	consumer.accept("Jeremy");
	consumer.accept("Paul");
	consumer.accept("Richard");
	
     }
     
      private void printNames(String name) {
        System.out.println(name);
    }
}
