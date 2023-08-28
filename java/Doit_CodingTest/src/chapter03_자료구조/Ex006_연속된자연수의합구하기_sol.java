package chapter03_자료구조;

import java.util.Scanner;

public class Ex006_연속된자연수의합구하기_sol {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int cnt = 0, start = 1, end = 1, sum = 1;
		while(end<=N) {
			if (sum<N) sum += ++end;
			else if (sum>N) sum -= start++;
			else {
				sum += ++end;
				cnt++;
			}
		}
		System.out.println(cnt);
		
	}

}
