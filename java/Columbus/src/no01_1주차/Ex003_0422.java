package no01_1주차;

import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Ex003_0422 {

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
			// chatGPT도 여기서 null인 열은 날린다고 했는데... 아닌가봐..;;
			// Stirng.valueOf에 대해 더 공부해보기 
		}
		
		bw.flush();
		
		br.close();
		bw.close();

	}

}
