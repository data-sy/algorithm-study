package no04_복습스터디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex화02_11720 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String str = br.readLine();

		int sum = 0;
		for (int i=0; i<N; i++){
			sum += Character.getNumericValue(str.charAt(i));
		}
		System.out.println(sum);
	}
}
