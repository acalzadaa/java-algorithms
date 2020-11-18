package com.core.sort;

import java.util.ArrayList;
import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) {
		Integer[] array = { 7, 6, 2, 5, 3, 4 };
		QuickSort.sort(array);
		System.out.println(new ArrayList<Integer>(Arrays.asList(array)));
	}

	public static <T extends Comparable<T>> void sort(T[] table) {
		quickSort(table, 0, table.length - 1);
	}

	private static <T extends Comparable<T>> void quickSort(T[] table, int first, int last) {

		if (first < last) {
			int pivotIndex = partition(table, first, last);
			quickSort(table, first, pivotIndex - 1);
			quickSort(table, pivotIndex + 1, last);
		}
	}

	private static <T extends Comparable<T>> int partition(T[] table, int first, int last) {
		/*
		 * Put the median of table[first], table[middle], table[last] into table[first],
		 * and use this value as the pivot.
		 */
		sort3(table, first, last);
		// Swap first element with median.
		swap(table, first, (first + last) / 2);

		// Select the first item as the pivot value.
		T pivot = table[first];
		int up = first;
		int down = last;
		do {
			/*
			 * Invariant: All items in table[first . . . up ‐ 1] <= pivot All items in
			 * table[down + 1 . . . last] > pivot
			 */
			while ((up < last) && (pivot.compareTo(table[up]) >= 0)) {
				up++;
			}
			// assert: up equals last or table[up] > pivot.
			while (pivot.compareTo(table[down]) < 0) {
				down--;

			}
			// assert: down equals first or table[down] <= pivot.
			if (up < down) { // if up is to the left of down.
				// Exchange table[up] and table[down].
				swap(table, up, down);
			}
		} while (up < down); // Repeat while up is left of down.
		// Exchange table[first] and table[down] thus putting the
		// pivot value where it belongs.
		swap(table, first, down);
		// Return the index of the pivot value.
		return down;

	}

	private static <T extends Comparable<T>> void swap(T[] table, int first, int last) {
		T temp = table[first];
		table[first] = table[last];
		table[last] = temp;
	}

	private static <T extends Comparable<T>> void sort3(T[] table, int first, int last) {
		int middle = (first + last) / 2;
		/*
		 * Sort table[first], table[middle], table[last].
		 */
		if (table[middle].compareTo(table[first]) < 0) {
			swap(table, first, middle);
		}
		// assert: table[first] <= table[middle]
		if (table[last].compareTo(table[middle]) < 0) {
			swap(table, middle, last);
		}
		// assert: table[last] is the largest value of the three.
		if (table[middle].compareTo(table[first]) < 0) {
			swap(table, first, middle);
		}
		// assert: table[first] <= table[middle] <= table[last].
	}

}
