package sorters;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class mainMerge {
	public static void main(String[] args) {
		try {
			if(args.length == 3) {
				ArrayList<Integer> list;
				PrintWriter outFile = new PrintWriter(new FileOutputStream("../../Resultat/" + args[0], false));
				int amount = Integer.parseInt(args[1]);
				int sizeOfArray = Integer.parseInt(args[2]);
				
				outFile.println("index, time in ns");
				
				for(int i = 1; i <= amount; ++i) {
					list = scrambler(sizeOfArray);
					long t0 = System.nanoTime();
					System.out.println(list);
					MergeSort.sort(list);
					System.out.println(list);
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
		Random random = new Random();
		for (int i = 0; i < n; i++) {
			list.add(random.nextInt(n));
		}
		return list;
	}
}

