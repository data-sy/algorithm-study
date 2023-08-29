package chapter03_자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex009_DNA비밀번호_sol {
	// 각 int 4개가 아니라 체크배열로
//	static int cntA=0, cntC=0, cntG=0, cntT=0;
	static int checkArr[];
	// 현재 상태도 배열로 & static 으로
	static int myArr[];
	// 4개 문자 중 조건을 만족하는 문자 개수
	static int checkSecret;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int S = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		
		char A[] = new char[S];
		A = br.readLine().toCharArray();
		checkArr = new int[4];
		myArr = new int[4];
		int Result = 0;

		st = new StringTokenizer(br.readLine());
		for (int i=0; i<4; i++) {
			checkArr[i] = Integer.parseInt(st.nextToken());
			// 0이면 항상 조건 만족하므로 ++
			if (checkArr[i]==0) checkSecret++;
		}
		
		for(int i=0; i<P; i++){
			Add(A[i]);
		}
		// 조건부를 각 값으로 하는 게 아니라 checkSecret으로 
		if (checkSecret == 4) Result++;
		
		// 슬라이딩 윈도우 처리 for문으로 하면 P에서 S까지 깔끔하네
		for(int i=P; i<S; i++) {
			int j = i-P;
			Add(A[i]);
			Remove(A[j]);
			if (checkSecret == 4) Result++;
		}
		System.out.println(Result);

		// 버퍼리더 닫아주는 게 안정적이야.
		br.close();

	}
	
	private static void Add(char c) {
		switch(c) {
			case 'A':
				myArr[0]++;
				if (myArr[0] == checkArr[0]) checkSecret++;
				break;
			case 'C':
				myArr[1]++;
				if (myArr[1] == checkArr[1]) checkSecret++;
				break;
			case 'G':
				myArr[2]++;
				if (myArr[2] == checkArr[2]) checkSecret++;
				break;
			case 'T':
				myArr[3]++;
				if (myArr[3] == checkArr[3]) checkSecret++;
				break;
		}		
	}
	private static void Remove(char c) {
		switch(c) {
			case 'A':
				myArr[0]--;
				if (myArr[0] == checkArr[0]) checkSecret--;
				break;
			case 'C':
				myArr[1]--;
				if (myArr[1] == checkArr[1]) checkSecret--;
				break;
			case 'G':
				myArr[2]--;
				if (myArr[2] == checkArr[2]) checkSecret--;
				break;
			case 'T':
				myArr[3]--;
				if (myArr[3] == checkArr[3]) checkSecret--;
				break;
		}		
	}
}
