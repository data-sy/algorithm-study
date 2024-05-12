package 재귀_백준;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex003_25501_2 {
	
	static int cnt;

	public static void main(String[] args) throws IOException {
		//https://www.acmicpc.net/problem/25501
		
		// 재귀함수 recursion, 팰린드롬 여부 확인 isPalin 함수를 쪼개서 만들어보기
		// substring 말고 투포인터로 해보기 
		// cnt를 전역변수로 만들어서 사용하기 

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		for (int i=0; i<N; i++) {
			String str = br.readLine();
			sb.append(isPalin(str)).append(" ").append(cnt).append("\n");			
		}
		System.out.println(sb);
	} 
	static int recursion(String str, int l, int r) {
		cnt++;
		// l>=r (홀수일 때는 1개 남아서 같아지고, 짝수일 때는 2개 남아서 엇갈려)
		// 서로 같지 않을 때는 리턴 0
		// 이 모든 걸 통과하면 => 그 다음 리컬
		if (l>=r) return 1;
		else if (str.charAt(l)!=str.charAt(r)) return 0;
		else return recursion(str, l+1, r-1);
		
	}
	static int isPalin(String str) {
		// 그냥 리컬션 함수 실행
		// 왜 굳이 따로 만들었을까? 아하! 새로운 스트링이 들어올 때마다 카운트 함수를 여기서 초기화해주기 위해
		cnt = 0;		
		return recursion(str, 0, str.length()-1);
	}
	
}
