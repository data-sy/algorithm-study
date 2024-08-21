package no01_카카오기출;

import java.util.Arrays;

public class Ex005_양궁대회_0820 {
	static int total;
	static int[] apeachInfo;
	static int[] ryanInfo;
	static int apeachScore, ryanScore;
	static int max;
	static int[] answer;
	static boolean hasWin;

	public static void main(String[] args) {

//		int n = 5;
//		int[] info = {2,1,1,1,0,0,0,0,0,0,0};

//		int n = 1;
//		int[] info = {1,0,0,0,0,0,0,0,0,0,0};

//		int n = 9;
//		int[] info = {0,0,1,2,0,1,1,1,1,1,1};

		int n = 10;
		int[] info = {0,0,0,0,0,0,0,0,3,4,3};

		// 8번, 18번 테케 : https://school.programmers.co.kr/questions/50503
		// 마지막에 answer가 커도 안 바꾼 채 break 해야 해

		total = n;
		apeachInfo = info.clone();
//		System.out.println(Arrays.toString(apeachInfo));
		ryanInfo = new int[11];
		answer = new int[11];
		hasWin = false;

		// 프로그래머스는
			// false이면 -1 리턴
			// 그 뒤에 코드로 그냥 answer리턴

		dupcombi(0, 0);

		if (hasWin) {
//			System.out.println("라이언 점수 : " + max);
			System.out.println(Arrays.toString(answer));
		} else {
			answer = new int[]{-1};
			System.out.println(Arrays.toString(answer));
		}

	}
	static void dupcombi(int index, int depth) {
		if (depth == total) {
			// 화살을 다 사용하지 않으면 return
			// 앞의 조건에서 depth가 그 역할을 한다고 생각했는데 내 생각대로 안 풀림;;
			int sum = 0;
			for(int i=0; i<11; i++) sum+=ryanInfo[i];
			if (sum != total) return;
			findAnswer();
			return;
		}

		for (int i=index; i<11; i++) {
			// 해당 인덱스의 화살 수 ++
			ryanInfo[i]++;
			// 재귀
			dupcombi(i, depth+1);
//			// 나오는 재귀
			ryanInfo[i]--;
			dupcombi(i+1, depth+1);
		}
	}
	static void findAnswer(){
		// 라이언 점수와 어피치 점수 차 비교
		apeachScore = 0;
		ryanScore = 0;
		for (int i=0; i<11; i++) {
			if (ryanInfo[i]==0 && apeachInfo[i]==0) continue;
			if (ryanInfo[i] > apeachInfo[i]) {
				ryanScore += (10 - i);
			} else apeachScore += (10 - i);
		}
		int score = ryanScore-apeachScore;

		if (max<score) {
//			System.out.println("라이언 배열====> " + Arrays.toString(ryanInfo));
//			System.out.println("score : " + score);
			hasWin = true;
//			System.out.println("라이언 점수 : " + ryanScore);
//			System.out.println("어피치 점수 : " + apeachScore);
			max = score;
			answer = ryanInfo.clone();
		} else if (max==score) {
			System.out.println("라이언 배열====> " + Arrays.toString(ryanInfo));
			for (int i = 10; i>=0; i--) {
				if (answer[i]<ryanInfo[i]) {
					answer = ryanInfo.clone();
					break;
				} else if (answer[i] > ryanInfo[i]) break;
			}
		}
	}


}
