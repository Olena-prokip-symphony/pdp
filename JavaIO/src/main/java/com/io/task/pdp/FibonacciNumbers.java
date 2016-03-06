package com.io.task.pdp;

import java.util.Scanner;

public class FibonacciNumbers {

	public static long nextFibonacci(int number) {
		return (number < 2) ? number : nextFibonacci(number - 1) + nextFibonacci(number - 2);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int number = scanner.nextInt();
		long fibonacciNumber = nextFibonacci(number);
		System.out.println(fibonacciNumber);

		scanner.close();
	}
}
