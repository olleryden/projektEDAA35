package sorters;

import java.util.*;
import java.util.Collections;

public class BucketSort {

	// Function to sort arr[] of size n
	// using bucket sort
	public static void sort(ArrayList<Integer> arr) {
		int n = arr.size() / 10;
		if (n <= 0)
			return;

		// 1) Create n empty buckets
		@SuppressWarnings("unchecked")
		Vector<Integer>[] buckets = new Vector[n];

		for (int i = 0; i < n; i++) {
			buckets[i] = new Vector<Integer>();
		}

		// 2) Put array elements in different buckets
		for (int i = 0; i < n; i++) {
			Integer idx = arr.get(i) / 10;
			buckets[idx].add(arr.get(i));
		}

		// 3) Sort individual buckets
		for (int i = 0; i < n; i++) {
			Collections.sort(buckets[i]);
		}

		// 4) Concatenate all buckets into arr[]
		int index = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < buckets[i].size(); j++) {
				arr.set(index,  buckets[i].get(j));
				index++;
			}
		}
	}
}

