package no04_복습스터디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex수02_1157 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();

		int[] arr = new int[26];
		for (int i=0; i<str.length(); i++){
			char ch = str.charAt(i);
			if (65<=ch && ch<=90) arr[ch-65]+=1;
			else arr[ch-97]+=1;
		}
		int max = arr[0];
		int maxIndex = 0;
		int cnt = 1;
		for (int i=1; i<26; i++){
			if (arr[i]==0) continue;
			if (arr[i]>=max) {
				cnt = arr[i]==max ? cnt+1 : 1; // 크면 1로 초기화, 같으면 cnt++
				max = arr[i];
				maxIndex = i;
			}
		}
		if (cnt>1) System.out.println("?");
		else System.out.println((char) (maxIndex+65));

	}
}
