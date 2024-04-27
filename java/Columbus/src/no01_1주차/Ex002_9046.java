package no01_1주차;

import java.util.Scanner;

public class Ex002_9046 {

	public static void main(String[] args) {	
		// https://www.acmicpc.net/problem/9046
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		sc.nextLine(); // 개행 문자를 소비하기 위한 추가 코드
		String[] arr = new String[N];
		for (int i=0; i<N; i++) {
			arr[i] = sc.nextLine().replaceAll(" ", ""); // 나중에 공백을 제일 많을 걸로 셀 수 있으니 미리 공백 제거
		}
		
		// 처음엔 Map 사용하려고 했는데 번거로워.
		// 소문자만 사용한다고 굳이 언급해줬으므로 a-z를 배열 순서로 처리해 버리자.
		// a의 아스키코드 97 ~ z의 아스키코드 122 활용. (26개)
		for (int i=0; i<N; i++) {
			String st = arr[i];
			// 카운트 
			int[] cntArr = new int[26];
			for (int j=0; j<st.length(); j++) {
				cntArr[st.charAt(j)-97]++;
			}
			// 최댓값 index 찾기 
			int max = cntArr[0];
			int maxIndex = 0;
			for (int j=1; j<26; j++) {
				if (max <= cntArr[j]) {
					max = cntArr[j];
					maxIndex = j;
				}				
			}
			char ch = (char) (maxIndex + 97); // 97 대신 'a'도 가능 
			for (int j=0; j<26; j++) {
				if (cntArr[j]==max && j!=maxIndex) ch = '?';
			}
			System.out.println(ch);	
		}
		
		// 리팩토링) 두 for문을 하나로 합쳐도 돼. else if 조건문으로 추가해서 
		
		sc.close();
	}

}
