package 재귀_백준;


import java.util.Scanner;

public class Ex001_27433 {

	public static void main(String[] args) {
		//https://www.acmicpc.net/problem/27433
		
		// 팩토리얼을 재귀로 접근해보자
		// int로 담아서 틀렸음. 
		// int : 10자리까지
		// long : 19자리 까지
		// 이보다 크다면 BigInteger
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		System.out.println(fact(N));
		
	} 
//	static long fact(int N) {
//		if (N>0) return N*fact(N-1); 
//		else return 1;
//	}
	// 재귀를 사용할 때도 if-else가 아니라
	// 기본 값으로 n*fact(n-1)을 하고 그 전에 if문으로 1인거 점검하면 빠르나봐
	// 테스트 해보니, 메모리는 살짝 더 쓰고.. 시간은 살짝 더 빨라 
	static long fact(int N) {
		if (N<=1) return 1;
		return N*fact(N-1); 
	}

	// 성능 좋은 풀이 : arrayList에 다음 연산을 담아 
	// arr.add(i*arr.get(i-1))
	
	
}
