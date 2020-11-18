package com.core.search;

public class LinearSearch {

	public static void main(String[] args) {
		String[] array = { "a", "b", "c", "d", "e" };

		System.out.println(search(array, "f"));
	}

	private static boolean search(String[] array, String str) {
		for (int x = 0; x < array.length; x++) {
			if (str == array[x]) {
				return true;
			}
		}
		return false;
	}

}
