package com.bridgelabz.algorithm;

import java.util.Arrays;

public class MergeSort {

	// Merge Sorting using recursive method.
	public static void mergeSortingRecursive(String[] array) {

		if (array == null) {
			return;
		}
		if (array.length > 1) {
			int mid = array.length / 2;      // Finding mid

			// Left Half of the array
			String[] left = new String[mid];
			for (int i = 0; i < mid; i++) {
				left[i] = array[i];
			}

			// Right Half of the array
			String[] right = new String[array.length - mid];
			for (int j = mid; j < array.length; j++) {
				right[j - mid] = array[j];
			}

			mergeSortingRecursive(left);                        // calling mergeSortingRecursive method for left half of the array.
			mergeSortingRecursive(right);                       // calling mergeSortingRecursive method for right half of the array.

			int left_index = 0;                                 // indicating left array index
			int right_index = 0;                                // indicating right array index
			int temp = 0;                                       // temp variable

			// Now Merging two arrays i.e., left array and right array.
			while (left_index < left.length && right_index < right.length) {
				if ((left[left_index].compareTo(right[right_index])) < 0) {
					array[temp] = left[left_index];
					left_index++;
				} else {
					array[temp] = right[right_index];
					right_index++;
				}
				temp++;
			}

			// Remaining element
			while (left_index < left.length) {
				array[temp] = left[left_index];
				left_index++;
				temp++;
			}
			while (right_index < right.length) {
				array[temp] = right[right_index];
				right_index++;
				temp++;
			}
		}
	}

	// Main Method
	public static void main(String[] args) {
		System.out.println("\t WELCOME TO MERGE-SORT \n");

		String[] array = { "C", "B", "R", "N", "J", "A", "W", "Z", "D", "K" };
		System.out.println("\nOriginal String Array :=  " + Arrays.toString(array));  // printing given string array.

		MergeSort.mergeSortingRecursive(array);                                       // calling mergeSortingRecursive method by passing input array to so recursively.

		System.out.println("\nSorted String Array :-  " + Arrays.toString(array));    // printing sorted String array.
	}
}
