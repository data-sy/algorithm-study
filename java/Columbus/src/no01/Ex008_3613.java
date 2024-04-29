package no01_1주차;

import java.util.Scanner;

public class Ex008_3613 {

	public static void main(String[] args) {
		// https://www.acmicpc.net/problem/3613
		// 변수명 조건을 정확히 알고 있어야 풀 수 있는 문제였어...
		// 출처 : https://pangseyoung.tistory.com/entry/백준-Java-vs-C-3613-Java
			// C++: 맨 뒤, 맨 앞 문자가 '_' 이면 에러, '_' 연속 두개면 에러
			// Java: 맨 앞 문자가 대문자면 에러
			// C++와 Java를 혼용하는 경우: 대문자와 '_'가 혼종이면 에러
			// 그 외: 소문자만 입력 될 경우 정상, 대문자 연속일 경우 정상
			// 예) https://www.acmicpc.net/board/view/92676
		// 실제 규칙에서는 첫 글자 숫자 x. 그 뒤로는 숫자 가능이지만 
		// 현재 문제에서는 알파벳과 밑줄로만 이루어져 있다고 입력조건이 붙음 (즉 숫자 고려하지 않아도 돼)
		
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		String str = sc.nextLine();
		String err = null;
		String errStr = "Error!";
			
		if (str.contains("_")) { // C++ -> Java
			// 3차 : 맨 앞, 맨 뒤가 _인 것도 에러처리
			if (str.startsWith("_") || str.endsWith("_")) {
				err=errStr;
			} else {
				for (int i=0; i<str.length(); i++) {
					char c = str.charAt(i);
					if (97<=c && c<=122) sb.append(c);
					else if (c=='_') {
						// 1차 시도 : 계속 실수하는 부분!! charAt 인덱스가 넘어가는 부분!!
						// _가 맨 뒤에 있으면 java.lang.StringIndexOutOfBoundsException 에러 
						if (i<str.length()-1) {
							// 2차 시도 : 언더바가 연속해서 들어가는 것도 에러 처리
							c = str.charAt(++i);
							if (97<=c && c<=122) sb.append(Character.toUpperCase(c));
							else {
								err=errStr;
								break;
							}
						}
					}
					else {
						err=errStr;
						break;
					}
				}
			}
		} else { // Java -> C++
			char first = str.charAt(0);
			if (97<=first && first<=122) {
				for (int i=0; i<str.length(); i++) {
					char c = str.charAt(i);
					if (97<=c && c<=122) sb.append(c);
					else if (65<=c && c<=90) {
						sb.append("_");
						sb.append(Character.toLowerCase(c));
					} else {
						err=errStr;
						break;
					}
				} 		
			} else err=errStr;;
		}
		
		if (err==null) System.out.println(sb);
		else System.out.println(err);
		
	}
	
	// 다른 풀이 : https://pangseyoung.tistory.com/entry/백-Java-vs-C-3613-Java
	// 점검 조건들을 모두 함수로 만들어서 사용 : C++ 문법 맞는지, Java 문법 맞는지, C++ -> Java, Java -> C++
	
	// 리팩토링 : 언더바 2개 있는 것 점검 그냥 contains("__") 쓰면 돼 (27줄)

}
