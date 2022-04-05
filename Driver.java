package sorters;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class Driver {
	public static void main(String[] args) {
		try {
			if(args.length == 3) {
				ArrayList<Integer> original = new ArrayList<Integer>();
				PrintWriter outFile = new PrintWriter(new FileOutputStream(args[0], false));
				int amount = Integer.parseInt(args[1]);
				int sizeOfArray = Integer.parseInt(args[2]);
				
				outFile.println("index, time in ns");
				
				for(int i = 1; i <= amount; ++i) {
					original = scrambler(sizeOfArray);
					long t0 = System.nanoTime();
					System.out.println(original);
					java.util.Collections.sort(original);    //Change this to your preferred sorting algorithm
					System.out.println(original);
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

