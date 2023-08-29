package chapter03_자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex009_DNA비밀번호 {
	static int cntA=0, cntC=0, cntG=0, cntT=0;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int S = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		
		char[] arr = br.readLine().toCharArray();
		// CCTGGATTG GATA

		st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int G = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		
		int cnt=0;
		for(int i=0; i<P; i++){
			Add(arr[i]);
		}

		if (cntA>=A && cntC>=C && cntG>=G && cntT>=T) {
			cnt++;
		}
		
		int start=0, end=P-1;
		while(end!=arr.length-1) {
			Remove(arr[start++]);
			Add(arr[start]);
			Remove(arr[end++]);
			Add(arr[end]);
			if (cntA>=A && cntC>=C && cntG>=G && cntT>=T) {
				cnt++;
			}
		}
		System.out.println(cnt);

	}
	// 주의 : break 까먹지 말고 넣기!!
	private static void Add(char c) {
		switch(c) {
			case 'A':
				cntA++;
				break;
			case 'C':
				cntC++;
				break;
			case 'G':
				cntG++;
				break;
			case 'T':
				cntT++;
				break;
		}		
	}
	private static void Remove(char c) {
		switch(c) {
			case 'A':
				cntA--;
				break;
			case 'C':
				cntC--;
				break;
			case 'G':
				cntG--;
				break;
			case 'T':
				cntT--;
				break;
		}		
	}
}
