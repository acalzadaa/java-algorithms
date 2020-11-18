package com.core.search;

public class BinarySearch {

	public static void main(String[] args) {

		Integer[] array = { 1, 3, 5, 7, 9, 11, 13, 15, 17, 19 };

		System.out.println(search(array, 29));

	}

	private static boolean search(Integer[] array, int i) {
		int lowIndex = 0;
		int highIndex = array.length - 1;
		int midIndex = lowIndex + ((highIndex - lowIndex) / 2);

		while (lowIndex <= highIndex) {

			System.out.println("Antes... i:" + i + " l:" + lowIndex + " m:" + midIndex + " h:" + highIndex);

			if (i == array[midIndex]) {
				return true;
			}

			if (i < array[midIndex]) {
				highIndex = midIndex - 1;
			}

			if (i > array[midIndex]) {
				lowIndex = midIndex + 1;
			}

			midIndex = lowIndex + ((highIndex - lowIndex) / 2);

			System.out.println("Despues... i:" + i + " l:" + lowIndex + " m:" + midIndex + " h:" + highIndex);

		}
		return false;
	}

}
