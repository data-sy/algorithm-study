package no04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex055_1541 {

	public static void main(String[] args) throws IOException  {
		// https://www.acmicpc.net/problem/1541

		// + 로 split할 때도 \\ 붙이기
		// 그냥 하면 Dangling quantifier '+' 오류

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// idea
		// -는 앞에서부터 하는 게 낫고, +는 먼저 처리하는 게 나아
		// 즉, A-B-C+D-E 가 있으면 (C+D)를 먼저하고 나머지는 쭉 그대로 연산
		// 스택에 쌓아서 + 나올 때만 뽑아서 연산 후 다시 넣자
		// 아! 이 때, 구분자가 -, + 2개라서 split을 어떻게 해야 할지 모르겠었는데
		// 어차피 우리는 +는 먼저 사용할 거니까 -로만 분리
		// A, B, C+D, E 이런 식으로 나오겠지?
		// 반복문 돌면서 그러면 +를 가진 원소에 대해서는 + 연산을 해서 수로 만들고
			// + 연산도 +로 split해서 원소들 모두 더하기
		// 그대로 다시 arr[0]에서 나머지를 다 빼는 계산을 하면 돼

		String[] splitMinus = br.readLine().split("-");
		String[] splitPlus;

		for (int i=0; i<splitMinus.length; i++) {
			String str = splitMinus[i];
			if (str.contains("+")) {
				int sum = 0;
				splitPlus = str.split("\\+");
				for (int j=0; j<splitPlus.length; j++) sum+=Integer.parseInt(splitPlus[j]);
				splitMinus[i] = Integer.toString(sum);
			}
		}
		int result = Integer.parseInt(splitMinus[0]);
		for (int i=1; i< splitMinus.length; i++) {
			result -= Integer.parseInt(splitMinus[i]);
		}
		System.out.println(result);
	}

}
