package no04_복습스터디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex013_1541 {
	
	public static void main(String[] args) throws IOException  {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] splitMinus = br.readLine().split("-");
		String[] splitPlus;

		for (int i=0; i<splitMinus.length; i++){
			if (splitMinus[i].contains("+")) {
				int sum = 0;
				splitPlus = splitMinus[i].split("\\+");
				for (String str : splitPlus) sum+=Integer.parseInt(str);
				splitMinus[i] = Integer.toString(sum);
			}
		}
		int result = Integer.parseInt(splitMinus[0]);
		for (int i=1; i<splitMinus.length; i++) {
			result-=Integer.parseInt(splitMinus[i]);
		}
		System.out.println(result);
	}

}
