package com.core.recursion;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RecursiveMethodsTest {

	@Test
	void testLength() {
		Assertions.assertEquals(10, RecursiveMethods.length("unodostres"));
		Assertions.assertEquals(0, RecursiveMethods.length(""));
	}

	@Test
	void testFactorial() {
		Assertions.assertEquals(1, RecursiveMethods.factorial(0L));
		Assertions.assertEquals(2, RecursiveMethods.factorial(2L));
		Assertions.assertEquals(6, RecursiveMethods.factorial(3L));
		Assertions.assertEquals(24, RecursiveMethods.factorial(4L));

	}

	@Test
	void testPower() {
		Assertions.assertEquals(16, RecursiveMethods.power(4, 2));
		Assertions.assertEquals(8, RecursiveMethods.power(2, 3));

	}

	@Test
	void testGreaterCommonDenominator() {
		Assertions.assertEquals(8, RecursiveMethods.gcd(24, 16));
	}

	@Test
	void testFibo() {
		Assertions.assertEquals(0, RecursiveMethods.fibonacci(0));
		Assertions.assertEquals(1, RecursiveMethods.fibonacci(1));
		Assertions.assertEquals(1, RecursiveMethods.fibonacci(2));
		Assertions.assertEquals(2, RecursiveMethods.fibonacci(3));
	}

	@Test
	void testFibo2() {
		Assertions.assertEquals(0, RecursiveMethods.fibonacci2(0));
		Assertions.assertEquals(1, RecursiveMethods.fibonacci2(1));
		Assertions.assertEquals(1, RecursiveMethods.fibonacci2(2));
		Assertions.assertEquals(2, RecursiveMethods.fibonacci2(3));
	}

	@Test
	void testPrime() {
		Assertions.assertFalse(RecursiveMethods.prime(1));
		Assertions.assertTrue(RecursiveMethods.prime(2));
		Assertions.assertTrue(RecursiveMethods.prime(3));
		Assertions.assertFalse(RecursiveMethods.prime(4));
		Assertions.assertTrue(RecursiveMethods.prime(5));
	}

}
