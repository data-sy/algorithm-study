package no02_중간고사;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;

public class Ex032_2870 {

	public static void main(String[] args) throws IOException {
		// https://www.acmicpc.net/problem/2870
		
		// 숫자가 너무 커지면 일차적으로는 String을 생각해 볼 수 있는데
		// 거기에 정렬까지 필요하다면 BigInteger 사용 
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		ArrayList<BigInteger> list = new ArrayList<>();

		for (int i=0; i<N; i++) {
			String str = "a" + br.readLine() + "a"; // charAt 인덱스 에러 방지 
			for (int j=0; j<str.length()-1; j++) {
				char ch = str.charAt(j);
				// idea
				// 만약 숫자가 나오면 그 다음이 문자가 나올 때까지 while 문으로 sb에딤있디기
				// while문이 끝나면 담긴 걸 int로 바꾼 뒤 list에 담기 
				if ( ch<97 || 122<ch) { // 숫자이면 = 알파벳 소문자가 아니면 
					sb.setLength(0);
					while(ch<97 || 122<ch) { // 문자가 나오면 break
						sb.append(ch);
						ch = str.charAt(++j);
					}
			        BigInteger bigInteger = new BigInteger(sb.toString());
					list.add(bigInteger);
				}
			}
		}
		Collections.sort(list);
		sb.setLength(0);
		for (BigInteger bigI : list) {
			sb.append(bigI).append("\n");
		}
		// String의 Collections.sort에서는 사전식 비교를 하므로 
			// 첫 번째 문자부터 비교를 시작
			// 해당 위치의 문자의 아스키 코드 값으로 비교를 수행
		// "231"<"43"
			// "2"가 "4"보다 아스키 코드 값이 작으므로 
		
		System.out.println(sb);
	}

}
