package no04_복습스터디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex목03_1343 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String str = br.readLine()+'A';

		if (str.contains("X")) {
			for (int i=0; i<str.length(); i++) {
				char ch = str.charAt(i);
				int cnt = 0;
				while(ch=='X') {
					cnt +=1;
					ch = str.charAt(++i);
				} // 기존 풀이 이 부분 더 깔끔하게 품! (no04-Ex050_1343)
				if (cnt%2==1) {
					sb.setLength(0);
					sb.append("-1A"); // 마지막에 하나 줄여줄거라서 미리 하나 추가
					break;
				} else if (cnt!=0) { // 짝수이면서 0이 아닐 때
					sb.append("AAAA".repeat(cnt/4));
					sb.append("B".repeat(cnt%4));
				}
				sb.append(ch);
			}

		} else sb.append(".".repeat(str.length())); // 얘도 -1 없이 A의 것까지 더해줘 버리자. 마지막에 하나 줄여줄 거라서

		sb.setLength(sb.length()-1);
		System.out.println(sb);
	}
}
