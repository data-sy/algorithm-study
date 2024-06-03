package no04;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex050_1343 {
	
	public static void main(String[] args) throws IOException  {
		// https://www.acmicpc.net/problem/1343

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str = br.readLine()+"+";
		
		int cnt=0;
		Boolean isPoli = true;

		// while
		if (str.contains("X")) {
			for(int i=0; i<str.length(); i++) {
				cnt=0;
				while(str.charAt(i)=='X') {
					cnt++;
					i++;
				}
				if (cnt%2==1) {
					isPoli = false;
					break;
				} else {
					sb.append("AAAA".repeat(cnt/4));
					sb.append("B".repeat(cnt%4));
				}
				sb.append(str.charAt(i));
			}			
		} else sb.append(".".repeat(str.length())); //..... 만 있는 경우 
		
		if (isPoli)	{
			// 맨 마지막 . 붙는 거 빼기
			sb.setLength(sb.length()-1);
			System.out.println(sb); 
		}
		else System.out.println(-1);

	}

}
