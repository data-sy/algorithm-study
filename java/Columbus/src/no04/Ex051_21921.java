package no04;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex051_21921 {
	
	public static void main(String[] args) throws IOException  {
		// https://www.acmicpc.net/problem/21921

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());

		int sum = 0;
		int[] arr = new int[N];
		for (int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if (i<X) sum+=arr[i];
		}

		int max = sum;
		int cnt = 1;
		for (int i=X; i<N; i++) {
			sum += arr[i] - arr[i-X];
			if (sum>max) {
				max = sum;
				cnt = 1;
			} else if (sum==max) cnt++;
		}
		
		if (max==0) System.out.println("SAD");
		else {
			System.out.println(max);
			System.out.println(cnt);
		}
		
	}


	// 시간이 획기적으로 빠른 애들은 스트링토크나이저부분을 직접 구현 
	// 하나 빼고 하나 더하는 거랑 내 풀이는 별 차이 없나봐
}
