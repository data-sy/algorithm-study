package no01_카카오기출;

import java.util.LinkedList;
import java.util.Queue;

public class Ex005_양궁_0820 {
	static int[] apeachInfo;
	static int cnt; // 현재 사용 가능한 화살 수
	static int apeachScore;
	static int ryanScore;
	static int[] ryanInfo;
	static int max;
	static int[] answer;

	public static void main(String[] args) {

		int n = 5;
		int[] info = {2,1,1,1,0,0,0,0,0,0,0};

		cnt = n;
		apeachInfo = info;
		ryanInfo = new int[11];
		answer = new int[11];

//		int n = 1;
//		int[] info = {1,0,0,0,0,0,0,0,0,0,0};
//
//		int n = 9;
//		int[] info = {0,0,1,2,0,1,1,1,1,1,1};
//
//		int n = 10;
//		int[] info = {0,0,0,0,0,0,0,0,3,4,3};

		recur(0);
		System.out.println(max);
		for (int i=0; i<11; i++) {
			System.out.print(answer[i] + ", ");
		}

	}
	static void recur (int index) {
		if (index>10) {
			if (cnt > 0 ) return; // n발을 다 쏘지 못한 경우는 사용 x
			else { // cnt<0 인 경우는 올 수 없어. 즉 cnt=0인 경우야. 즉, n발 다 쐈으면 점수 계산
				// 라이언 점수와 어피치 점수 차 비교
				ryanScore = 0;
				apeachScore = 0;
				for (int i=0; i<11; i++) {
					if(ryanInfo[i]>apeachInfo[i]) {
						ryanScore += (10 - i);
					} else apeachScore += (10 - i);
				}
				int score = ryanScore-apeachScore;
				System.out.println(score);

				if (max<score) {
					System.out.println("라이언 점수 : " + ryanScore);
					System.out.println("어피치 점수 : " + apeachScore);
					max = ryanScore;
					answer = ryanInfo.clone();
				} else if (max==ryanScore) {
					for (int i = 10; i>=0; i--) {
						if(answer[i]<ryanInfo[i]) {
							answer = ryanInfo.clone();
							break;
						}
					}
				}
				return;
			}
		}

		// 재귀 돌리기
		for (int num=apeachInfo[index]+1; num<=cnt; num++) {
			// 해당 화살 개수 선택하고 다음 인덱스로 가기
			if (cnt>num) {
				ryanInfo[index] = num;
				recur(index+1);
				cnt-=num;
				// 먹었던 거 되돌리고 다음 인덱스로 가기
				ryanInfo[index] = 0;
				cnt+=num;
				recur(index+1);
			}
		}

	}
}
