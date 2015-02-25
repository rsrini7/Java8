package com.srini.functional;

import java.util.stream.IntStream;

public class Prime {
	
	public static void main(String[] args) {
		System.out.println(isPrime(7));
		
	}
	
	static boolean isPrime(int n){
		return n>1 && IntStream.range(2, n).noneMatch(ind-> n % ind==0);
	}

}
