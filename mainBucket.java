package sorters;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class mainBucket {
	private static Random random = new Random();
	
	public static void main(String[] args) {
		try {
			if(args.length == 3) {
				ArrayList<Integer> list;
				PrintWriter outFile = new PrintWriter(new FileOutputStream("../../Resultat/" + args[0], false));
				int amount = Integer.parseInt(args[1]);
				int sizeOfArray = Integer.parseInt(args[2]);
				
				outFile.println("index, time in ns");
				
				for(int i = 1; i <= amount; ++i) {
					list = almostSort(sizeOfArray);
					long t0 = System.nanoTime();
					BucketSort.sort(list);
					long t1 = System.nanoTime();
					outFile.println(i + ", " + (t1 - t0));
				}
				outFile.flush();
				outFile.close();
			}
			else {
				System.out.println("Nothing done, wrong number of arguments.");
			}
		}
		catch(Exception e) {
			System.out.println("Error: " + e.toString());
		}
	}
	private static ArrayList<Integer> scrambler(int n) {
		ArrayList<Integer> list = new ArrayList<Integer>(n);
		for (int i = 0; i < n; i++) {
			list.add(random.nextInt(n));
		}
		return list;
	}
	
	private static ArrayList<Integer> almostSort(int n) {
		ArrayList<Integer> list = scrambler(n);
		Collections.sort(list);
		for (int i = 0; i < (n / 10); i++) {
			int replaceInd = random.nextInt(list.size());
			int replaceVal = random.nextInt(list.size());
			list.set(replaceInd, replaceVal);
		}
		return list;
	}
	
	private static ArrayList<Integer> almostReverse(int n) {
		ArrayList<Integer> list = almostSort(n);
		Collections.reverse(list);
		return list;
	}
}

