package chapter03_자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex003_구간합구하기_sol {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int dataNo = Integer.parseInt(st.nextToken());
		int quizNo = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		// 부분합 배열만 사용하므로 기존 데이터 배열 만들 필요 없음
		// int 말고 long
		// 사이즈를 미리 하나 키워두면 입력받은 수 그대로 index로 쓸 수 있고 start-1도 사용 가능 (index 0 있으니)
		long[] sumArr = new long[dataNo+1];
		int sum = 0;
		for (int i=1; i<dataNo; i++) {
			sumArr[i] = sumArr[i-1] + Integer.parseInt(st.nextToken());
		}
		
		for (int i=0; i<quizNo; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			System.out.println(sumArr[m] - sumArr[n-1]);
		}
		
	}

}
