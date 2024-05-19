package no04;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Ex050_1343_시도2 {
	
	public static void main(String[] args) throws IOException  {
		// https://www.acmicpc.net/problem/1343
		
		// .....는 -1이 아니라 .....로 출력 (https://www.acmicpc.net/board/view/140697)
		// split 시 \\. 사용
			// 출처 : https://mytory.net/archives/285
			// split의 인자로 들어가는 String 토큰이 regex 정규식이기 때문 (regex: 정규표현식, 레겍스, 레귤러 익스프레션)
			// 정규식에서 .은 무작위의 한 글자를 의미 => 따라서 모든 문자가 토근이 되어 배열에 남는 게 없어짐
			// 또한 String 안에서 이스케이프 코드는 \ 1개가 아니라 \\를 붙여줘야 함 
		// 내부 점 개수만큼 빈 값이 들어가
			// XXXX....XXX.....XX
			// [XXXX, , , , XXX, , , , , XX]
		// . 만 존재하면 빈 배열 반환 
			// ....
			// []
		// 빈 배열은 : null이 아니면서 길이가 0
		
		// 지금 풀이는 .으로 끝날 때랑 X로 끝날 때를 구분 못 해
		// .XX.XX. 에 대해
		// .BB.BB 가 나와버려 
		// ...XXXX.... 에 대해 
		// ...AAAA 가 나와버려 


		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str = br.readLine();
		String[] arr = str.split("\\.");
		System.out.println(str);
		System.out.println(Arrays.toString(arr));
		
		int len = 0;
		Boolean isPoli = true;
		
		if (arr!=null && arr.length>0) {
			for(int i=0; i<arr.length; i++) {
//			String str = arr[i];
				len = arr[i].length();
				if (len%2==1) {
					isPoli = false;
					break;
				} else {;
				sb.append("AAAA".repeat(len/4));
				sb.append("B".repeat(len%4));
				}
				sb.append(".");
			}			
		} else sb.append(".".repeat(str.length()+1));

		if (isPoli) {
			sb.setLength(sb.length()-1);
			System.out.println(sb);
		}
		else System.out.println(-1);
	}

}
