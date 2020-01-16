package com.epam.engx.cleancode.naming.task3;

public class HarshadNumbers {

	public static void main(String[] args) {
		long Limit = 1000; 
		for (int i = 1; i <= Limit; i++) {
			if (i % getSumofDigits(i) == 0) {
				System.out.println(i);
			}
		}
	}

	private static int getSumofDigits(int Number) {
		int Sum = 0;
		while (Number != 0) {
            Sum += Number % 10;
            Number = Number / 10;
        }
		return Sum;
	}

}
