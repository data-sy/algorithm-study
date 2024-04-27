package no01_1주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex005_9996 {

	public static void main(String[] args) throws IOException {
		// https://www.acmicpc.net/problem/9996
			
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String pattern = br.readLine();
		int index = pattern.indexOf('*');
		String f = pattern.substring(0, index);
		String b = pattern.substring(index+1);
		
		String[] arr = new String[N];
		for (int i=0; i<N; i++) {
			arr[i] = br.readLine();
		}
		
		for (String str : arr) {
			// 1차 시도 
//			if (str.substring(0, f.length()).equals(f) && str.substring(str.length()-b.length()).equals(b)) System.out.println("DA");
			// 이건 조건에 맞는 애들한테는 에러가 안 나지만, 조건에 안 맞는 짧은 애들한테서는 에러가 나 
			// 예) 패턴이 abc*def인데 들어온 데이터가 we 일 때 
			// 2차 시도
// 			if (lenF<lenStr && lenB<lenStr) {
			// abc*cde에서 abcde처럼 겹치는 애는 통과해버림 => len 조건 수정  
			int lenStr = str.length();
			int lenF = f.length();
			int lenB = b.length();
			if (lenF+lenB<=lenStr) {
				if (str.substring(0, lenF).equals(f) && str.substring(lenStr-lenB).equals(b)) System.out.println("DA");
				else System.out.println("NE");
			} else System.out.println("NE");
		}
		// 리팩토링) DA, NE 바로 출력이라 for 문 하나로 사용 가능. 굳이 배열에 넣지 않고 
		// 리팩토링) 메서드 startsWith, endsWith 사용하면 인덱스 에러 신경 쓸 필요 없음 
		br.close();
	}

}
