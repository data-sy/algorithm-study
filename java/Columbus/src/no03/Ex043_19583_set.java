package no03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Ex043_19583_set {

	public static void main(String[] args) throws IOException {
		//https://www.acmicpc.net/problem/19583
		
		// 성능 비교 
		// 1. set.contains
		// 2. map.get
		// 하려 했는데 앞의 문제와 달리 이번엔 검사할 문자열에 중복이 있을 수 있음
		// 아하! 이럴 때 set을 쓰는구나! 

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int S = strToTime(st.nextToken());
		int E = strToTime(st.nextToken());
		int Q = strToTime(st.nextToken());

		HashSet<String> set1 = new HashSet<>();
		// 그냥 cnt 세면 중복 방지 안 됨 
		HashSet<String> set2 = new HashSet<>();
		String line;
		while((line = br.readLine())!=null){
			String[] chat = line.split(" ");
			if (strToTime(chat[0])<=S) set1.add(chat[1]);
			if (E<=strToTime(chat[0]) && strToTime(chat[0])<=Q) {
				if (set1.contains(chat[1]))	set2.add(chat[1]);
			}
		}
		System.out.println(set2.size());
		
	}
	static int strToTime(String str) {
		return Integer.parseInt(str.replace(":", ""));
	}
	
	// 리팩토링 
	// split말고 토크나이저 써도 돼
	// 굳이 숫자로 바꾸지 않고 문자열.compareTo 사용하면 끝 (들어오는 포맷이 일정하므로)
	
}
