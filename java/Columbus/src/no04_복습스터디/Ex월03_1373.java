package no04_복습스터디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex월03_1373 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringBuilder sb = new StringBuilder();

		str = "0".repeat((3-str.length()%3)%3) + str;
		for (int i=0; i<str.length(); i+=3){
			int num = 4*Character.getNumericValue(str.charAt(i)) + 2*Character.getNumericValue(str.charAt(i+1)) + Character.getNumericValue(str.charAt(i+2));
			sb.append(num);
		}
		System.out.println(sb);
	}
}
