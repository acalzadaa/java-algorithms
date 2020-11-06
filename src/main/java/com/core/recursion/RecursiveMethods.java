package com.core.recursion;

import java.util.stream.IntStream;

public class RecursiveMethods {

	public static int length(String str) {
		if (str == null || str.isEmpty()) {
			return 0;
		} else {
			return 1 + length(str.substring(1));
		}
	}

	public static void printChars(String str) {
		if (str == null || str.isEmpty()) {
			return;
		} else {
			System.out.println(str.charAt(0));
			printChars(str.substring(1));
		}
	}

	public static long factorial(long number) {
		if (number == 0) {
			return 1;
		} else {
			return number * factorial(number - 1);
		}
	}

	public static long power(double number, long exponent) {
		if (exponent == 0) {
			return 1;
		} else {
			return (long) (number * power(number, exponent - 1));
		}
	}

	public static long gcd(long number1, long number2) {
		if (number1 % number2 == 0) {
			return number2;
		} else {
			return gcd(number2, number1 % number2);
		}
	}

	public static long fibonacci(int number) {
		if (number == 0) {
			return 0;
		} else if (number == 1) {
			return 1;
		} else {
			return fibonacci(number - 1) + fibonacci(number - 2);
		}
	}

	public static long fibonacci2(int number) {
		if (number == 0) {
			return 0;
		} else {
			return RecursiveMethods.fibo(1, 0, number);
		}
	}

	public static long fibo(int fibCurrent, int fibPrevious, int number) {
		if (number == 1) {
			return fibCurrent;
		} else {
			return fibo(fibCurrent + fibPrevious, fibCurrent, number - 1);
		}
	}

	public static boolean prime(long number) {

		if (number <= 1) {
			return false;
		} else {
			return IntStream.range(2, (int) number).boxed().filter(num -> number % num == 0).count() == 0 ? true
					: false;
		}

	}

	public static int linearSearch(Object[] items, Object target, int posFirst) {

		if (posFirst == items.length) {
			return -1;
		} else if (target.equals(items[posFirst])) {
			return posFirst;
		} else {
			return linearSearch(items, target, posFirst + 1);
		}

	}

	private static <T> int binarySearch(T[] items, Comparable<T> target, int first, int last) {
		if (first > last) {
			return -1;
		} else {
			int middle = (first + last) / 2;
			int compResult = target.compareTo(items[middle]);
			if (compResult == 0) {
				return middle;
			} else if (compResult < 0) {
				return binarySearch(items, target, first, middle - 1);
			} else {
				return binarySearch(items, target, middle + 1, last);
			}
		}
	}

	public static <T> int binarySearch(T[] items, Comparable<T> target) {
		return binarySearch(items, target, 0, items.length - 1);
	}

}
