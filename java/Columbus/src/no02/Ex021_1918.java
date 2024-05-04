package no02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Ex021_1918 {

	public static void main(String[] args) throws IOException{
		//https://www.acmicpc.net/problem/1918
		
		// 덱 사용 	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		// 우선 괄호 없이 +-*/ 연산은
			// */을 한 덩어리로 처리하면서 스택에 쌓고
			// +-를 큐로 추출 
		// 괄호가 있으면 그 괄호 안의 문자열을 postfix
		
		
		
	}
	
	// 괄호 없는 버전에 
	// 왼쪽 괄호가 나왔을 때의 조건문 추가
		// 오른쪽 괄호가 나올 때 까지 str을 뽑아서 다시 postfix. 즉, 재귀 
}
