package exampractice;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SimpleJava {
	public static String result;

	public static void main(String[] args) throws IOException {

		boolean b = false;
		do {
			try {
				System.out.print("Do you want to enter a new array?");
				Scanner n = new Scanner(System.in);
				boolean bn = n.nextBoolean();
				if (bn == true) {
					get_numbers();
					getTotal();
					getAverage();
					checkDivisible();
					getBiggerThan();
					print2largest();
				} else if (bn == false) {
					System.out.println("Bye");
				}

			} catch (InputMismatchException e) {
				System.out.println("Invalid input!");
			}

		} while (!b);
	}

	static int[] arr;
	static int size;
	static int[] values;
	static int sum;
	static int avr;
	static int divisible;

	public static int[] get_numbers() {
		System.out.println("Please enter the length of the array and then th numbers for array :");
		Scanner keyboard = new Scanner(System.in);
		size = keyboard.nextInt();
		values = new int[size]; // create a new array with the given size
		for (int i = 0; i < size; i++) {
			values[i] = keyboard.nextInt();
		}
		System.out.println("There are " + ((values.length)) + " numbers in the array");
		arr = values;
		return arr;
	}

	public static void getTotal() {
		sum = 0;
		int i = 0;
		while (i < size) {
			sum += arr[i];
			i++;
		}
		System.out.println("The sum of all values is: " + sum);

	}

	public static void getAverage() {
		avr = 0;

		avr = sum / values.length;

		System.out.println("The Average of the array is: " + avr);

	}

	public static void getBiggerThan() {
		System.out.println("Numbers less than 5: ");
		for (int x = 0; x < values.length; x++) {
			if (values[x] < 5) {
				System.out.println(values[x]);
			}
		}
		System.out.println("All numbers greater than the average: ");
		for (int x = 0; x < values.length; x++) {
			if (values[x] > avr) {
				System.out.println(values[x]);
			}
		}
		System.out.println("Numbers greater than 65: ");
		for (int x = 0; x < values.length; x++) {
			if (values[x] > 65) {
				System.out.println(values[x]);
			}
		}
	}

	static void print2largest() {
		int i, first, second, third;

		/* There should be at least two elements */
		if (size < 3) {
			System.out.print(" Invalid Input ");
			return;
		}

		third = first = second = Integer.MIN_VALUE;
		for (i = 0; i < size; i++) {
			/*
			 * If current element is smaller than first
			 */
			if (arr[i] > first) {
				third = second;
				second = first;
				first = arr[i];
			}

			/*
			 * If arr[i] is in between first and second then update second
			 */
			else if (arr[i] > second) {
				third = second;
				second = arr[i];
			}

			else if (arr[i] > third)
				third = arr[i];
		}

		System.out.println("Three largest elements are " + first + " " + second + " " + third);

	}
	static void checkDivisible() {
		divisible = 0;
		if ((avr % 7) == 0) {
		divisible = avr / 7;
		}
		System.out.println("this number is divisible: " + divisible);
		
	}

}
