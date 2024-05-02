package no02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Ex016_10799_2 {

	public static void main(String[] args) throws IOException{
		//https://www.acmicpc.net/problem/10769
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		// (( push
		// () + size
		// )) pop & + 1
		// )( 아무것도 안 함
		
		// 한 값을 넣었다 뺐다 하는 거라서 스택 필요없어 (9012_4처럼)
		// 얘는 확실히 더 빨라지네 
		// 기존 방법 : 16268KB, 180ms
		// 이 방법 : 15700KB, 156ms
		
		int size = 0;
		int sum = 0;
		
		for (int i=1; i<str.length(); i++) {
			if (str.charAt(i-1)=='(') {
				if (str.charAt(i)=='(') size ++; // ((
				else sum+=size; // ()
			} else if (str.charAt(i)==')') { // ))
				size--;
				sum++;
			}
		}
		System.out.println(sum);
		
	}

}
