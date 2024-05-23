package no04;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex048_14916 {
	
	public static void main(String[] args) throws IOException  {
		// https://www.acmicpc.net/problem/14916

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int cnt2 = 0;
		int cnt5 = 0;
		// 일의 자리 떼고 
		int q = N/10*10;
		// 일의 자리
		int r = N%10;
		
		if (N == 1 || N == 3) cnt2=-1;
		else if (N%2==0) {
			cnt2 = r/2;
			cnt5 = q/5;
		} else {
			cnt2 = (r/2+3)%5;
			cnt5 = (N-2*cnt2)/5;
		}

		System.out.println(cnt2+cnt5);
	}
	
	// 그냥 반복문 돌리는 게 더 성능이 좋아 ㅋㅋ 
	// 2를 하나씩 빼면서 (2동전 개수++) 5의 배수 되는지 점검
	// 계속 빼다가 음수가 되어버리면 -1 아니면 cnt

}
