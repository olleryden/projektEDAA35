package sorters;

import java.util.ArrayList;

public class MergeSort {

	void merge(ArrayList<Integer> list, int left, int mid, int right) {
		int n1 = mid - left + 1;
		int n2 = right - mid;
		
		ArrayList<Integer> L = new ArrayList<Integer>();
		ArrayList<Integer> R = new ArrayList<Integer>();
		
		for (int i = 0; i < n1; i++) {
			L.add(list.get(left + i));
		}
		for (int j = 0; j < n2; j++) {
			R.add(list.get(mid + 1 + j));
		}
		
		int i = 0;
		int j = 0;
		
		int k = left;
		while (i < n1 && j < n2) {
			if (L.get(i) <= R.get(j)) {
				list.set(k, L.get(i));
				i++;
			} else {
				list.set(k, R.get(j));
				j++;
			}
			k++;
		}
		
		while (i < n1) {
			list.set(k, L.get(i));
			i++;
			k++;
		}
		
		while (j < n2) {
			list.set(k, R.get(j));
			j++;
			k++;
		}
	}
	
	
	void sort(ArrayList<Integer> list, int left, int right) {
		if (left < right) {
			int mid = left + (right - left)/2;
			sort(list, left, mid);
			sort(list, mid+1, right);
			merge(list, left, mid, right);
		}
	}
	
	static void printArray(ArrayList<Integer> array) {
		int n = array.size();
		for (int i = 0; i < n; i++) {
			System.out.print(array.get(i) + " ");
		}
		System.out.println();
	}
	
	public static void main(String args[]) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for (int i = 0; i < 1000; i++) {
			int element = (int) (1 + Math.random() * 1000);
			list.add(element);
		}
		
		MergeSort ob  = new MergeSort();
		ob.sort(list, 0, list.size() - 1);
		printArray(list);
	}
}


