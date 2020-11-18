package com.core.sort.example;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class People implements Comparable<People> {

	private String lastName;
	private String firstName;
	private int birthday;

	@Override
	public int compareTo(People o) {
		int result = lastName.compareTo(o.lastName);
		if (result == 0) {
			return firstName.compareTo(o.firstName);
		} else {
			return result;
		}
	}

}
