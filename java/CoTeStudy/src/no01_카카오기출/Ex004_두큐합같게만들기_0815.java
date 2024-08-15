package no01_카카오기출;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class Ex004_두큐합같게만들기_0815 {

	public static void main(String[] args) {

//		int[] queue1 = {3, 2, 7, 2};
//		int[] queue2 = {4, 6, 5, 1};

//		int[] queue1 = {1, 2, 1, 2};
//		int[] queue2 = {1, 10, 1, 2};

//		int[] queue1 = {1, 1};
//		int[] queue2 = {1, 5};

		// 임계점 2n+2에 대한 테스트 케이스
		int[] queue1 = {1, 1, 1, 1, 1, 1};
		int[] queue2 = {1, 1, 1, 1, 11, 1};

		int answer = 0;
		int n = queue1.length;
		long q1Sum = 0;
		long q2Sum = 0;
		Queue<Integer> q1 = new LinkedList<>();
		Queue<Integer> q2 = new LinkedList<>();

		for (int i=0; i<n; i++){
			q1.add(queue1[i]);
			q1Sum += queue1[i];
			q2.add(queue2[i]);
			q2Sum += queue2[i];
		}
		long check = 0;

		if ((q1Sum+q2Sum)%2==0) {
			check = (q1Sum+q2Sum)/2;
		} else answer=-1; // 프로그래머스에서 리턴으로 바꿔

		while(q1Sum!=check){
			if (q1Sum>q2Sum) {
				int tmp = q1.poll();
				q1Sum-=tmp;
				q2Sum+=tmp;
				q2.add(tmp);
			} else if (q1Sum<q2Sum) {
				int tmp = q2.poll();
				q2Sum-=tmp ;
				q1Sum+=tmp;
				q1.add(tmp);
			} else {
				// 리턴 answer
			}
			answer++;
			if (answer>2*n+2) { // 끝까지 다 돌려봤을 때
				System.out.println(answer);
				answer=-1;
				break;
			}
		}
		System.out.println(answer);

	}
}
