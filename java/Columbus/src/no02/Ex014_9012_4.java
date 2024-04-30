package no02;


import java.util.Stack;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex014_9012_4 {

	public static void main(String[] args) throws IOException{
		// https://www.acmicpc.net/problem/9012
		// 스택 없이 숫자 놀음 해보기
			// 아주 사~알짝 더 빠름.. 큰 차이는 안 나네..
		// 이 방법 : 메모리 14228KB, 시간 128ms 
		// 스택 방법 : 메모리 14300KB, 시간 132ms
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int i=0; i<T; i++) {
			String str = br.readLine();
			int cnt = 0;

			String result = "YES";
			for (int j=0; j<str.length(); j++){
				if (str.charAt(j)=='(') cnt++;
				else {
					cnt--;;
					if (cnt<0) {
						result = "NO";
						break;
					}
				}
			}
			
			// (가 남는 경우  (예) (())(())
			if (cnt!=0) result = "NO";
			System.out.println(result);
		}

	}

}
