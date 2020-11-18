package com.core.sort;

import java.util.ArrayList;
import java.util.Arrays;

public class BubbleSort {

	public static void main(String[] args) {
		Integer[] array = { 7, 6, 2, 5, 3, 4 };
		BubbleSort.sort(array);
		System.out.println(new ArrayList<Integer>(Arrays.asList(array)));
	}

	public static <T extends Comparable<T>> void sort(T[] toSort) {
		for (int i = 0; i < toSort.length - 1; i++) {
			boolean swapped = false;
			for (int j = 0; j < toSort.length - 1 - i; j++) {
				if (toSort[j].compareTo(toSort[j + 1]) > 0) {
					swapped = true;
					T swap = toSort[j + 1];
					toSort[j + 1] = toSort[j];
					toSort[j] = swap;
				}
			}
			if (!swapped) {
				break;
			}
		}
	}

}
