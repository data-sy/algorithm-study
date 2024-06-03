package no04_복습스터디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex010_14916 {
	
	public static void main(String[] args) throws IOException  {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		// 이번엔 반복문 방법으로 풀어보자!
		int cnt2 = 0;
		while (N%5!=0){
			N-=2;
			cnt2++;
		}

		if (N<0) System.out.println(-1);
		else System.out.println(cnt2+N/5);

	}

}
