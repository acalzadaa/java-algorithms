package com.core.bigo;

public class Bigo {
	public static void main(String[] args) {

		/* testing n or n2 */
		System.out.println("n squared!");
		System.out.println("5, " + test1(5));
		System.out.println("10, " + test1(10));
		System.out.println("20, " + test1(20));
		System.out.println("50, " + test1(50));

		System.out.println("n linear!");
		System.out.println("5, " + test2(5));
		System.out.println("10, " + test2(10));
		System.out.println("20, " + test2(20));
		System.out.println("50, " + test2(50));

		System.out.println("n squared!");
		System.out.println("5, " + test3(5));
		System.out.println("10, " + test3(10));
		System.out.println("20, " + test3(20));
		System.out.println("50, " + test3(50));

		System.out.println("n squared!");
		System.out.println("5, " + test4(5));
		System.out.println("10, " + test4(10));
		System.out.println("20, " + test4(20));
		System.out.println("50, " + test4(50));

	}

	private static int test1(int n) {
		int x = 0;
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				x++;

		return x;
	}

	private static int test2(int n) {
		int x = 0;
		for (int i = 0; i < n; i++)
			for (int j = 0; j < 2; j++)
				x++;

		return x;
	}

	private static int test3(int n) {
		int x = 0;
		for (int i = 0; i < n; i++)
			for (int j = n - 1; j >= i; j--)
				x++;

		return x;
	}

	private static int test4(int n) {
		int x = 0;
		for (int i = 1; i < n; i++)
			for (int j = 0; j < i; j++)
				x++;

		return x;
	}

}
