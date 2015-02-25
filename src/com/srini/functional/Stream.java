package com.srini.functional;

import java.util.ArrayList;
import java.util.List;

public class Stream {

public static void main(String[] args) {
	//System.out.println(IntStream.range(0, 5).reduce((a,b)->Math.max(a, b)));
	
	
			Student students=new Student();
			students.setScore(90);
			students.setName(null);
			List<Student> lst = new ArrayList();
			lst.add(students);
			lst.stream()
	        .filter(student -> student.getScore() > 80) // filter
	        .findAny()         //Any student matching to the filter
	        .map(Student::getName)    // mapping to students name
	        .ifPresent(System.out::println);  // print if name of the student is not Null
}
	
}
