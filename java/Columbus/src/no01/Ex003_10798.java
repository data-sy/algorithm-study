package no01;

import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Ex003_10798 {

	public static void main(String[] args) throws IOException{
		// https://www.acmicpc.net/problem/10798
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 조건에서 주어진 최대값 15를 바로 사용하면 max를 찾을 필요 없어
		char[][] arr = new char[15][5];
		for (int i=0; i<5; i++) {
			String str = br.readLine();
			for (int j=0; j<str.length(); j++) {
				arr[j][i] = str.charAt(j);
			}
		}
		for (int i=0; i<15; i++) {
			bw.write(String.valueOf(arr[i]));
			// chatGPT도 valueOf는 null인 열은 날린다고 했는데... 아닌가봐..;;
			// 아! char의 초기값은 null이 아니라 '\u0000' (오답노트에 상세설명)
		}
		
		bw.flush();
		
		br.close();
		bw.close();

	}

}
