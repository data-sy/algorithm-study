package no02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex023_2840 {

	public static void main(String[] args) throws IOException{
		// https://www.acmicpc.net/problem/2840

		// [문제 조건] 바퀴에 같은 글자는 두 번 이상 등장하지 않는다. 
		// https://www.acmicpc.net/board/view/137851
		// 중복 체크 추가 
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine()); 
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		String[] arr = new String[N];
		String result = null;
		int index = 0;

		for (int i=0; i<K; i++ ) {
			st = new StringTokenizer(br.readLine()); 
			int S = Integer.parseInt(st.nextToken());
			String ch = st.nextToken();
			// + S의 의미 : S만큼 회전
			index+=S;
			// % N의 의미 : 회전 결과를 배열 내부로 돌리기 
			index%=N;
			
			// 중복 체크
			boolean isUsed = false;
			for (int j=0; j<N; j++) {
				if(ch.equals(arr[j])) {
					if(index!=j) {
						isUsed = true;
						break;
					}
				}
			}
			if (isUsed) {
				result="!";
				break;
			}

			// 로직 수행 
			if (arr[index]==null) arr[index] = ch;
			else if (arr[index].equals(ch)) {
				continue;
			}
			else {
				result="!";
				break;				
			} 
		}
		if (result!=null) System.out.println(result);
		else {
			// 0~N-1까지가 아니라 N~2N-1까지가 되도록 해서 한 바퀴 다 돌도록 만듦
			index+=N;
			for (int i=0; i<N; i++) {				
				if (arr[index%N]==null) sb.append("?");
				else sb.append(arr[index%N]);
				index--;
			}
			System.out.println(sb);
		}
		
	}
	
}
