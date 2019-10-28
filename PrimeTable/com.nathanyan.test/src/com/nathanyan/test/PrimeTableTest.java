package com.nathanyan.test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.nathanyan.domain.PrimeTable;

public class PrimeTableTest {
	PrimeTable pt1 = new PrimeTable(1);
	PrimeTable pt3 = new PrimeTable(3);
	PrimeTable pt10 = new PrimeTable(10);

	@Test
	public void getPrimeByOrder() {

		assertEquals(2, pt10.getMax(1));
		assertEquals(5, pt10.getMax(3));
		assertEquals(29, pt10.getMax(10));
	}

	@Test
	public void getMapWithOnePrime() {
		boolean[] result = { false, false, true };
		assertArrayEquals(result, pt1.getMap());
	}

	@Test
	public void getMapWith3Prime() {
		boolean[] result = { false, false, true, true, false, true };
		assertArrayEquals(result, pt3.getMap());
	}

	@Test
	public void getMapWith10Primes() {
		boolean[] restult = { false, false, true, true, false, true, false, true, false, false, false, true, false,
				true, false, false, false, true, false, true, false, false, false, true, false, false, false, false,
				false, true };

		assertArrayEquals(restult, pt10.getMap());
	}

	@Test
	public void primeTableWith1() {
		int[][] table1 = pt1.getTable();
		int[][] result = { { 0, 2, }, { 2, 4 }, { 3, 6 }, { 5, 10 } };

		for (

				int i = 0; i < table1.length; i++) {
			for (int j = 0; j < table1.length; j++) {
				assertEquals(result[i][j], table1[i][j]);
			}
		}

	}

	@Test
	public void primeTableWith3() {
		int[][] table3 = pt3.getTable();
		int[][] result = { { 0, 2, 3, 5 }, { 2, 4, 6, 10 }, { 3, 6, 9, 15 }, { 5, 10, 15, 25 } };

		for (

				int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				assertEquals(result[i][j], table3[i][j]);
			}
		}

	}

	@Test
	public void primeTableWith10() {
		int[][] table10 = pt10.getTable();
		int[][] result = { { 0, 2, 3, 5, 7, 11, 13, 17, 19, 23, 29 }, { 2, 4, 6, 10, 14, 22, 26, 34, 38, 46, 58 },
				{ 3, 6, 9, 15, 21, 33, 39, 51, 57, 69, 87 }, { 5, 10, 15, 25, 35, 55, 65, 85, 95, 115, 145 },
				{ 7, 14, 21, 35, 49, 77, 91, 119, 133, 161, 203 }, { 11, 22, 33, 55, 77, 121, 143, 187, 209, 253, 319 },
				{ 13, 26, 39, 65, 91, 143, 169, 221, 247, 299, 377 },
				{ 17, 34, 51, 85, 119, 187, 221, 289, 323, 391, 493 },
				{ 19, 38, 57, 95, 133, 209, 247, 323, 361, 437, 551 },
				{ 23, 46, 69, 115, 161, 253, 299, 391, 437, 529, 667 },
				{ 29, 58, 87, 145, 203, 319, 377, 493, 551, 667, 841 }, };

		for (int i = 0; i < 11; i++) {
			for (int j = 0; j < 11; j++) {
				assertEquals(result[i][j], table10[i][j]);
			}
		}

	}

}
