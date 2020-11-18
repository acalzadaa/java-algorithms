package com.core.sort;

import java.util.ArrayList;
import java.util.Arrays;

public class SelectionSort {

	public static void main(String[] args) {

		Integer[] array = { 7, 6, 2, 5, 3, 4 };
		SelectionSort.sort(array);
		System.out.println(new ArrayList<Integer>(Arrays.asList(array)));

	}

	public static <T extends Comparable<T>> void sort(T[] table) {

		int n = table.length;

		for (int fill = 0; fill < n - 1; fill++) {
			int posMin = fill;

			for (int next = fill + 1; next < n; next++) {
				if (table[next].compareTo(table[posMin]) < 0) {
					posMin = next;
				}
			}

			T temp = table[fill];
			table[fill] = table[posMin];
			table[posMin] = temp;
		}
	}
}
