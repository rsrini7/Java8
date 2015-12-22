package com.srini.functional;

public class Simple {

	

	     public static void main(String []args){
	        System.out.println("Hello World");
	        java.util.List<String> l = new java.util.ArrayList();
	        l.add("srini");
	        
	        l.stream()
	        .map(s -> {
	        System.out.println("map: " + s);
	        return s.toUpperCase();
	    })
	    .forEach(s -> System.out.println("forEach: " + s));
	     }

}
