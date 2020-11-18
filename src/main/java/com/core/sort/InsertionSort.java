package com.core.sort;

import java.util.ArrayList;
import java.util.Arrays;

public class InsertionSort {

	public static void main(String[] args) {
		Integer[] array = { 7, 6, 2, 5, 3, 4 };
		InsertionSort.sort(array);
		System.out.println(new ArrayList<Integer>(Arrays.asList(array)));
	}

	public static <T extends Comparable<T>> void sort(T[] table) {
		for (int nextPos = 1; nextPos < table.length; nextPos++) {
			insert(table, nextPos);
		}
	}

	private static <T extends Comparable<T>> void insert(T[] table, int nextPos) {
		T nextVal = table[nextPos];
		while (nextPos > 0 && nextVal.compareTo(table[nextPos - 1]) < 0) {
			table[nextPos] = table[nextPos - 1];
			nextPos--;
		}

		table[nextPos] = nextVal;
	}

}
