package 재귀_백준;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex003_25501 {

	public static void main(String[] args) throws IOException {
		//https://www.acmicpc.net/problem/25501
		// 팰린드롬 여부를 재귀로 접근해보자
		// 팰린드롬 : 앞에서부터 읽었을 때와 뒤에서부터 읽었을 때가 같은 문자열
		
		// 투포인터 변수명 : left-right => l, r  // start-end => s, e
		
		// 1. substring : 메모리 278876KB, 시간 460ms
		// 2. 인덱스 투포인터 : 메모리 19092KB, 시간 228ms
		// 시간 차이 엄청 나는군!

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		for (int i=0; i<N; i++) {
			String str = br.readLine();
			int[] arr = isPalin(str, 1);
			sb.append(arr[0]).append(" ").append(arr[1]).append("\n");
		}
		System.out.println(sb);
	} 
	
	static int[] isPalin(String str, int cnt) {
		int len = str.length();
		if (str.charAt(0)!=str.charAt(len-1)) return new int[]{0, cnt};
		else if (len<=2) return new int[] {1, cnt+len-1};
		else return isPalin(str.substring(1, len-1), ++cnt);
		
	}
	
	// substring 사용하면 느려지나? substring 대신 인덱스를 투포인터로 왼쪽 오른쪽에서 이동 시키는 방법으로!
	// recursion과 isPalin을 쪼개서 만들어보자!
	// cnt를 전역변수로 다루면 매개변수로 사용하지 않아도 돼. (대신 새 문자열 시작할 때 초기화 해야겠)
	
}
