package 중간고사;

import java.util.Scanner;

public class Ex031_2960 {

	public static void main(String[] args) {
		// https://www.acmicpc.net/problem/2960
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		boolean[] arr = new boolean[N+1];
		for (int i=2; i<=N; i++) {
			arr[i]= true;
		}
		
		int cnt = 0;
		int j = 0; 
		boolean isFind = false;
		for (int i=2; i<=N; i++) {
			if (arr[i]) {
				for (j=i; j<=N; j+=i) {
					if (arr[j]) {
						cnt++; 
						arr[j]=false; 
						if (cnt==K) {
							isFind = true;
							break;
						}
					}
				}
				if (isFind) break;
			}
		}
		System.out.println(j);

	}

}
