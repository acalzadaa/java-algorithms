package com.core.sort;

import java.util.ArrayList;
import java.util.Arrays;

public class ShellSort {

	public static void main(String[] args) {
		Integer[] array = { 7, 6, 2, 5, 3, 4 };
		ShellSort.sort(array);
		System.out.println(new ArrayList<Integer>(Arrays.asList(array)));
	}

	public static <T extends Comparable<T>> void sort(T[] table) {
		int gap = table.length / 2;
		while (gap > 0) {
			for (int nextPos = gap; nextPos < table.length; nextPos++) {
				insert(table, nextPos, gap);
			}

			if (gap == 2) {
				gap = 1;
			} else {
				/*
				 * Empirical studies of this approach show that the performance is O(n5/4) or
				 * maybe even O(n7/6), but there is no theoretical basis for this result (M. A.
				 * Weiss, Data Structures and Problem Solving Using Java [Addison‐Wesley,
				 * 1998],p. 230).
				 */
				gap = (int) (gap / 2.2);
			}
		}
	}

	private static <T extends Comparable<T>> void insert(T[] table, int nextPos, int gap) {
		T nextVal = table[nextPos];
		while ((nextPos > gap - 1) && (nextVal.compareTo(table[nextPos - gap]) < 0)) {
			table[nextPos] = table[nextPos - gap];
			nextPos -= gap;
		}
		table[nextPos] = nextVal;
	}

}
