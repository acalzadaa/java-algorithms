package com.core.sort.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sorts {

	public static void main(String[] args) {
		/* creating list */
		List<People> peopleList = new ArrayList<>();
		peopleList.add(new People("one", "dos", 23));
		peopleList.add(new People("tres", "cuatro", 24));
		peopleList.add(new People("cinco", "seis", 26));

		/* sort */
		Collections.sort(peopleList);
		System.out.println(peopleList);

		/* using custom sort */
		Collections.sort(peopleList, new ComparePeople());
		System.out.println(peopleList);

	}
}
