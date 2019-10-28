package com.nathanyan.domain;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class PrimeTable {
	private int size;
	private int max;
	private boolean[] map;
	private int[][] table;

	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);
		System.out.println("How many primes you want?");
		int input = sc.nextInt();
		System.out.println("Your input is: " + input);

		PrimeTable pt = new PrimeTable(input);
		pt.printTable(pt.getTable());
	}

	public PrimeTable(int size) {
		super();

		this.size = size;
		this.max = getMax(size);
		this.map = createMap(max);
		this.table = createTable(map);
		// printTable(table);
	}

	public int getMax(int size) {
		int max = 0;
		int count = 0;
		for (int i = 0; i < 1000; i++) {
			if (isPrime(i)) {
				max = i;
				count++;
			}
			if (count == size) {
				break;
			}
		}
		return max;

	}

	public void printTable(int[][] table) {
		Stream.of(table).forEach(x -> System.out.println(Arrays.toString(x)));

	}

	public boolean[] createMap(int max) {
		boolean[] map = new boolean[max + 1];
		for (int i = 0; i <= max; i++) {
			map[i] = true;
		}

		// Mark primes with True
		for (int i = 0; i < map.length; i++) {
			// Call isPrime method to distinct primes
			map[i] = isPrime(i);
		}
		return map;
	}

	public int[][] createTable(boolean[] map) {
		int[][] table = new int[size + 1][size + 1];
		// Create label of table
		int count = 1;
		for (int j = 2; j < map.length; j++) {

			if (map[j]) {

				table[0][count] = j;
				table[count][0] = j;
				count++;
			}
		}
		// Fill up the table with products of primes
		for (int i = 1; i < size + 1; i++) {
			for (int j = 1; j < size + 1; j++) {
				table[i][j] = table[0][i] * table[j][0];
			}
		}
		return table;

	}

	public static boolean isPrime(int n) {
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

	/**
	 * @return the size
	 */
	public int getSize() {
		return size;
	}

	/**
	 * @param size the size to set
	 */
	public void setSize(int size) {
		this.size = size;
	}

	/**
	 * @return the range
	 */
	public int getMax() {
		return max;
	}

	/**
	 * @param range the range to set
	 */
	public void setMax(int range) {
		this.max = range;
	}

	/**
	 * @return the map
	 */
	public boolean[] getMap() {
		return map;
	}

	/**
	 * @param map the map to set
	 */
	public void setMap(boolean[] map) {
		this.map = map;
	}

	/**
	 * @return the table
	 */
	public int[][] getTable() {
		return table;
	}

	/**
	 * @param table the table to set
	 */
	public void setTable(int[][] table) {
		this.table = table;
	}

}
