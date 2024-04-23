package no01_1주차;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Scanner;

public class Ex000_test {
	
	public static void main(String[] args) throws IOException {
		
		// 아스키코드로 알파벳 세기 테스트 : char - 97 
//		String str = "abczyx";
//		for (int i=0; i<str.length(); i++) {
//			int n = str.charAt(i)-97;
//			System.out.println(n);
//		}
		
		// Scanner사용 
//		Scanner sc = new Scanner(System.in);
//		int a = sc.nextInt();
//		sc.nextLine(); // 개행 문자를 소비하기 위한 추가 코드를 넣어줘야 에러가 나지 않
//		String b = sc.nextLine();
//		int c = sc.nextInt();
//		
//		System.out.println("a : " + a);
//		System.out.println("b : " + b);
//		System.out.println("c : " + c);
		
		// BufferReader 사용
		// 입력 데이터 ABCDE
		// 			abcde
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String[] arr = new String[2];
		for(int i=0; i<2; i++) {
			arr[i] = br.readLine();
			System.out.println(arr[i]);
		}
		
		
	}

}
