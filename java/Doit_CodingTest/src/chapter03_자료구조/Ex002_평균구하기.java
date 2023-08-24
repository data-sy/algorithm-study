package chapter03_자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex002_평균구하기 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());

//		// 데이터를 저장해서 계속 사용해야 하는 문제에서는 arr 처리할 필요 있지만
//		// 여기서는 그 때 그 때 바로 사용하므로 필요 없
//		int[] arr = new int[N];

		int M = 0;
		// double은 10?자리, float은 5자리
		float sum = 0;
		int score;
		
		while(st.hasMoreTokens()) {
			score = Integer.parseInt(st.nextToken());
			// 최댓값 찾기
			if(M < score) {
				M = score;
			}
			// 점수 합산
			sum+=score;
		}
		
		System.out.println(sum/N/M*100);

	}

}
