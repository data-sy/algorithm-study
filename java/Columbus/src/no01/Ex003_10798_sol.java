package no01;

import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Ex003_10798_sol {

	public static void main(String[] args) throws IOException{
		// null은 콘솔창에서 안 보일 뿐 데이터 안에는 들어있어서 계속 틀렸던 것!
		// https://www.acmicpc.net/board/view/112680
		// https://www.acmicpc.net/board/view/121271
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		char[][] arr = new char[5][15];
		for (int i=0; i<5; i++) {
			String str = br.readLine();
			for (int j=0; j<str.length(); j++) {
				arr[i][j] = str.charAt(j);
			}
		}
		for (int j=0; j<15; j++) {
			for (int i=0; i<5; i++) {
				if(arr[i][j] == (char) 0) continue;
				bw.write(String.valueOf(arr[i][j]));		
		}}
		
		bw.flush();
		
		br.close();
		bw.close();

	}

}
