package com.srini.functional;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    public int getAge() {
		return age;
	}
    
    public String getName() {
		return name;
	}

    @Override
    public String toString() {
        return name+" "+age;
    }
    
    public void print(){
    	System.out.println("name : "+name);
    }
    
    public static void printPersonNames(List<Person> list,Consumer<Person> consumer){
    	for(Person person: list){
    		consumer.accept(person);
    	}
    }
    
    public static void main(String[] args) {
    	List<Person> persons =
    		    Arrays.asList(
    		        new Person("Max", 18),
    		        new Person("Peter", 23),
    		        new Person("Pamela", 23),
    		        new Person("David", 12));
    	
    	persons.stream().collect(Collectors.groupingBy(a -> a.age)).forEach((k,v)->System.out.printf("%s %s\n",k,v));
    	//System.out.println(""+persons.stream().filter(a-> a.age > 20).collect(Collectors.averagingInt(p -> p.age)));
    	//System.out.println(""+persons.stream().collect(Collectors.summarizingInt(p -> p.age)));
    	//System.out.println(persons.stream().filter(a -> a.age >= 18).map(a-> a.name).collect(Collectors.joining(" and ", "In India ", " are allowed.")));
    	
    	//persons.stream().collect(Collectors.toMap(p->p.age, p->p.name, (n1,n2)->n1+", "+n2, HashMap::new)).forEach((k,v)->System.out.printf("age: %s , name: %s\n",k,v));
    	//persons.stream().collect(Collectors.toMap(Person::getName, Person->Person)).forEach((k,v)->System.out.printf("%s %s \n",k,v));
    	
    	
    	printPersonNames(persons, p -> p.print());
    	
	}
}


