package com.nathanyan.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class isPrmieTest {

	// Since isPrime is static. I copied the method into test case for Test.
	public boolean isPrime(int n) {
		if (n == 0 || n == 1) {
			return false;
		}
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

	@Test
	// Expect False with input 0 and 1
	public void isPrime_withInput_0_1() {
		assertFalse(isPrime(0));
		assertFalse(isPrime(1));
	}

	@Test
	// Expect True with primes
	public void isPrime_withInput_Primes() {
		assertTrue(isPrime(2));
		assertTrue(isPrime(3));
		assertTrue(isPrime(5));
		assertTrue(isPrime(29));
		assertTrue(isPrime(193));
		assertTrue(isPrime(1487));
		assertTrue(isPrime(10007));
	}

	@Test
	// Expect False with non prime numbers
	public void isPrime_withInput_NonPrimes() {
		assertFalse(isPrime(4));
		assertFalse(isPrime(9));
		assertFalse(isPrime(18));
		assertFalse(isPrime(116));
		assertFalse(isPrime(543));
		assertFalse(isPrime(9983));
	}

}
