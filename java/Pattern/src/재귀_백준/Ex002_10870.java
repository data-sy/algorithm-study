package 재귀_백준;


import java.util.Scanner;

public class Ex002_10870 {

	public static void main(String[] args) {
		//https://www.acmicpc.net/problem/27433
		
		// 피보나치를 재귀로 접근해보자
		// pibo 함수의 리턴을 long으로 하면 런타임 에러가 남 why??

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		System.out.println(pibo(N));
		
	} 
	
	static int pibo(int N) {
		if (N==1) return 1;
		else if (N==0) return 0;
		else return pibo(N-1) + pibo(N-2);
	}
	
	// 2보다 작으면 자기 자신을 리턴하면 코드 깔끔
	// 성능 좋은 풀이 : 배열에 누적해서 담기

}
