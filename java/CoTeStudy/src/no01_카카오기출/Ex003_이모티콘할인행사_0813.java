package no01_카카오기출;

import java.io.IOException;

public class Ex003_이모티콘할인행사_0813 {

	static int[][] userArr;
	static int[] emoArr;
	static int n, m;
	static int[] curArr, answer;

	public static void main(String[] args) throws IOException {

		int[][] users = {{40, 2900}, {23, 10000}, {11, 5200}, {5, 5900}, {40, 3100}, {27, 9200}, {32, 6900}};
		int[] emoticons = {1300, 1500, 1600, 4900};
		userArr = users;
		emoArr = emoticons;
		n = users.length;
		m = emoticons.length;
		answer = new int[2];

		// 결국 완탐 문제!
		// 중복 조합이라 생각하면 될 듯!

		curArr = new int[m];
		dupCombi(0);

		System.out.println("플러스 가입자 수 : " + answer[0]);
		System.out.println("이모티콘 판매액 : " + answer[1]);


	}
	static void dupCombi(int index) {
		if (index == m) {
			findAnswer();
			return;
		}

		for (int i=10; i<=40; i+=10) {
			curArr[index] = i;
			dupCombi(index+1);
		}
	}

	static void findAnswer(){
		int plusCnt = 0;
		int totalPrices = 0;
		for (int[] user : userArr) {
			int userPercent = user[0];
			int userPrice = user[1];
			int sum = 0;
			for (int i=0; i<m; i++) {
				if(userPercent<=curArr[i]) {
					sum+=(emoArr[i]/100)*(100-curArr[i]);
				}
			}
			if (userPrice<=sum) plusCnt++;
			else totalPrices+=sum;
		}
		if (answer[0] < plusCnt) {
			answer[0] = plusCnt;
			answer[1] = totalPrices;
			answer[1] = totalPrices;
		} else if (answer[0] == plusCnt) {
			answer[1] = Math.max(answer[1], totalPrices);
		}
	}
}
