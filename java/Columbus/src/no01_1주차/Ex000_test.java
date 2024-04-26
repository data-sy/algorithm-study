package no01_1주차;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;
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
		
//		// BufferReader 사용
//		// 입력 데이터 ABCDE
//		// 			abcde
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
////		StringTokenizer st = new StringTokenizer(br.readLine());
//		
//		String[] arr = new String[2];
//		for(int i=0; i<2; i++) {
//			arr[i] = br.readLine();
//			System.out.println(arr[i]);
//		}

//		// for문 안에서 i 조작 ok 
//		for (int i=0; i<10; i++) {
//			System.out.println(i++);
//		}
		
//		// ++ 붙이는 것
//		int n = 4;
//		int i = 2;
//		int j = 2;
//		int a = n*i++;
//		int b = n*(j++);
//		// 같은 건가봐.
//		System.out.println(a);
//		System.out.println(i);
//		System.out.println(b);
//		System.out.println(j);

//		// boolean 배열 초기값 :false
//		boolean[] arr = new boolean[3];
//		System.out.println(Arrays.toString(arr));
		
//		// 조건을 만족하지 않으면 아얘 for문에 안 들어 가는지 => yes
//		String str = "ab";
//		for(int i=2; i<str.length(); i++) System.out.println(i);
		
//		// 문자열 곱셈
//		// 자바는 * 로 문자열 곱셈 못함
//		// repeat 메서드 사용 (자바11)
//		String str = "string";
//		int n = 3;
////		str = n*"0" + str; // 빨간 줄 
//		str = "0".repeat(n) + str;
//		System.out.println(str);
		
//		// sb insert 사용
//		// int 넣어도 알아서 문자열 처리 됨 
//		StringBuilder sb = new StringBuilder();
//		int n = 1;
//		int m = 2;
//		sb.insert(0, n);
//		sb.insert(0, m);
//		System.out.println(sb);
		
		int n = 10;
		int m = 5;
		n /= m;
		System.out.println(n);
		
		
	}

}
