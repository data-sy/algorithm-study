package no01_카카오기출;

import java.io.IOException;

public class Ex002_택배배달과수거하기_0808 {
	public static void main(String[] args) throws IOException {

		// 테케 공유 : https://school.programmers.co.kr/questions/43351

		// 1차 코드의 반례
//		int cap = 2;
//		int n = 2;
//		int[] deliveries = {5, 0};
//		int[] pickups = {0, 3};
//		int answer = 0;
		// 처음에는 반복문 멈추는 조건을 dp, pp로 뒀어
		// 그래서 index가 0으로 오기만 하면 멈춤..
		// 멈추는 게 위치가 아니라 값이어야 해! maxdp, maxpp

		// 코테는 통과 했는데... 이 반례는 통과 못함.. 뭐징?
		// 다른 분이 올려준 기댓값은 4, 실행한 결괏값은 6....
		int cap = 2;
		int n = 2;
		int[] deliveries = {0, 0};
		int[] pickups = {4, 0};
		int answer = 0;
		// dpNum, ppNum 초기값을 모두 0으로 줘버려서 문제였어
		// dSumArr[0], pSumArr[0]으로 주니 제대로 돌아감

		// Case1
//		int cap = 4;
//		int n = 5;
//		int[] deliveries = {1, 0, 3, 1, 2};
//		int[] pickups = {0, 3, 0, 4, 0};
//		long answer = 0;
		// Case2
//		int cap = 2;
//		int n = 7;
//		int[] deliveries = {1, 0, 2, 0, 1, 0, 2};
//		int[] pickups = {0, 2, 0, 1, 0, 2, 0};
//		long answer = 0;

		// 각 변수명 의미
		// dSumArr : deliveries의 누적합
		// dp : deliveries의 ㅇㅇㅇ을 가리키는 포인터
		// dpNum : dp 찾을 때 사용한 배열의 값 (같은 수이면 가장 왼쪽에 포인터가 있어야 하므로)
		// maxdp : 배달해야 할 전체 양 (여기서 cap만큼 빼갈꺼야)

		// pSumArr : pickups의 누적합
		// 이하 생략

		long[] dSumArr = new long[n];
		long[] pSumArr = new long[n];

		dSumArr[0] = deliveries[0];
		pSumArr[0] = pickups[0];
		int dp = 0;
		long dpNum = dSumArr[0]; // 0으로 했을때로 통과가 되어버림 (실제로는 틀렸는데)
		int pp = 0;
		long ppNum = pSumArr[0]; // 0으로 했을때로 통과가 되어버림 (실제로는 틀렸는데)
		for (int i=1; i<n; i++){
			dSumArr[i] = dSumArr[i - 1] + deliveries[i];
			if (dpNum<dSumArr[i]) {
				dp=i;
				dpNum = dSumArr[i];
			}
			pSumArr[i] = pSumArr[i - 1] + pickups[i];
			if (ppNum<pSumArr[i]) {
				pp=i;
				ppNum = pSumArr[i];
			}
		}

		// 디버깅
		for (int i=0; i<n; i++){
			System.out.print(dSumArr[i] + ", ");
		}
		System.out.println();
		for (int i=0; i<n; i++){
			System.out.print(pSumArr[i] + ", ");
		}
		System.out.println();
		System.out.println("dp : " + dp);
		System.out.println("dpNum : " + dpNum);
		System.out.println("pp : " + pp);
		System.out.println("ppNum : " + ppNum);
		////

		long maxdp = dpNum;
		long maxpp = ppNum;
		while(maxdp>0 || maxpp>0){
			System.out.println("==============반복 시작=============");
			System.out.println("maxdp : " + maxdp);
			System.out.println("maxpp : " + maxpp);

//			System.out.println("항상 dp가 큰가?");
			answer += Math.max(dp+1, pp+1);
			System.out.println("이 때의 answer : " + answer);

			maxdp-=cap;
			maxpp-=cap;

			while (dSumArr[dp]>=maxdp){
				dp--;
				System.out.println("dp 줄이면서 찾기 : " + dp);
				if (dp<0) break;
			}
			dp +=1;
			System.out.println("새로운 dp 위치 : " + dp);

			while (pSumArr[pp]>=maxpp) {
				pp--;
				System.out.println("pp 줄이면서 찾기 : " + pp);
				if (pp<0) break;
			}
			pp +=1;
			System.out.println("새로운 dp 위치 :" + pp);

		}

		answer*=2;
		System.out.println("answer : " + answer);

	}

}
