package no03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Ex040_1158 {

	public static void main(String[] args) throws IOException {
		//https://www.acmicpc.net/problem/1158
		
		// 1. LinkedList & 인덱스 놀음 (성능 차이 많이 남)
		// 2. deque 사용 (확실히 문제 푸는 속도 빨라져. 코드 구현만 하면 되니까)
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		LinkedList<Integer> list = new LinkedList<>();		
		for (int i=0; i<N; i++) {
			list.offer(i+1);
		}

		sb.append("<");
		
		int check = K-1;
		while(list.size()>1) {
			sb.append(list.remove(check)).append(", ");
			// -1 : 앞에서 remove 때문에 인덱스 하나 줄어든 것 처리
			check = (check+K-1)%list.size();
		}
		sb.append(list.poll()).append(">");
		System.out.println(sb);
		
	}
	
}
