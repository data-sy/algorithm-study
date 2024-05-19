package no04;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex050_1343_시도1 {
	
	public static void main(String[] args) throws IOException  {
		// https://www.acmicpc.net/problem/1343
		
		// .....는 -1이 아니라 .....로 출력 (https://www.acmicpc.net/board/view/140697)

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str = br.readLine()+".";

		// idea
		// . 나올 때까지 돌린 뒤 
			// if cnt가 홀수이면 -1, break
			// else
				// 4로 나눈 몫만큼 AAAA넣고
				// 4로 나눈 나머지만큼 B 넣기
		// 지금 이 풀이대로 하면 끝이 ...으로 끝날 때도 마지막에 .을 하나 빼줘버려서 안 맞아!
			// 맨 마지막이 .. 이었으면 안 빼고, .이었으면 빼는 걸로 수정하자
		// 한 70쯤 가서 틀리는 듯!!
		// 이거는 반복문 안의 반복문 & 점검 조건도 늘어나네..
		
		int i = 0;
		Boolean isPoli = true;
		
		if (str.contains("X")) {
			while(i<str.length()-1) { // X.으로 끝나면 > 되서 멈추고, ..으 끝나면 =되서 멈춤
				int cnt = 0;
				while(str.charAt(i++)!='.') cnt++;
				if (cnt%2==1) {
					isPoli = false;
					break;
				}
				else {
					sb.append("AAAA".repeat(cnt/4));
					sb.append("B".repeat(cnt%4));
				}
				sb.append(".");
			}			
//		} else isPoli = false; //..... 만 있는 경우 
		} else sb.append(".".repeat(str.length())); //..... 만 있는 경우 
		
		if (isPoli)	{
			// 맨 마지막 . 붙는 거 빼기
			if (str.charAt(str.length()-2)=='X') sb.setLength(sb.length()-1);
			System.out.println(sb); 
		}
		else System.out.println(-1);
	}

}
