package chapter03_자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex003_구간합구하기 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int dataNo = Integer.parseInt(st.nextToken());
		int quizNo = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[dataNo];
		int[] sumArr = new int[dataNo];
		int sum = 0;
		for (int i=0; i<dataNo; i++) {
			arr[i]= Integer.parseInt(st.nextToken());
			sum += arr[i];
			sumArr[i] = sum;
		}
		
		int result = 0;
		for (int i=0; i<quizNo; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken())-1;
			int end = Integer.parseInt(st.nextToken())-1;
			if (start != 0) result = sumArr[end] - sumArr[start-1];
			else result = sumArr[end];
			System.out.println(result);
		}
		
	}

}
