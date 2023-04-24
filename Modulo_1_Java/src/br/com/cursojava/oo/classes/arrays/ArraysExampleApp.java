package br.com.cursojava.oo.classes.arrays;

import java.util.Arrays;

public class ArraysExampleApp {

	public static void main(String[] args) {
		int[] numbers = { 42, 1, 17, 25, 16 };
		System.out.println(Arrays.toString(numbers));
		System.out.println(Arrays.binarySearch(numbers, 17));
		System.out.println(Arrays.binarySearch(numbers, 15));
		
		Arrays.sort(numbers);
		System.out.println(Arrays.toString(numbers));
		System.out.println(Arrays.binarySearch(numbers, 17));
		System.out.println(Arrays.binarySearch(numbers, 15));
	}
}