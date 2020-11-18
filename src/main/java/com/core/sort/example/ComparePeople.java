package com.core.sort.example;

import java.util.Comparator;

public class ComparePeople implements Comparator<People> {

	@Override
	public int compare(People left, People right) {
		return left.getBirthday() - right.getBirthday();
	}

}
