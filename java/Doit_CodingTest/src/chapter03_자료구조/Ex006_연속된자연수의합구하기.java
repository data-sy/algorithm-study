package chapter03_자료구조;

import java.util.Scanner;

public class Ex006_연속된자연수의합구하기 {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int cnt = 1, start = 1, end = 1, sum = 1;
		// 조건을 end!=N로 두면 N일 때는 안 돌아도 되고, cnt를 1에서 시작하면 돼.
		while(end!=N) {
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
