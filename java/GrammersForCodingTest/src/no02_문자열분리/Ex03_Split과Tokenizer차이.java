package no02_문자열분리;

import java.util.Scanner;

public class Ex03_Split과Tokenizer차이 {

	public static void main(String[] args) {
		
		// 둘 중 뭐가 더 빠른지에 대한 고찰 출처 : https://velog.io/@effirin/Java-StringTokenizer와-Split-메서드-언제-써야할까 

		// Split
			// 결과값이 String[] 배열
			// 빈 문자열 토큰 ㅇ
			// 정규표현식을 사용해야 함
		
		// Tokenizer
			// 결과값이 String 문자열
			// 빈 문자열은 토큰으로 인식 x
			// 단점 : 구분자는 한 문자로
			// 구분자 자리에 여러 문자를 사용하면 각각이 구분자가 됨 => 두 문자 이상의 구분자는 split 사용
		
		// 언제 토크나이저를 사용하나
			// 구분자에 유니코드 x , 한 문자일 때
			// 반환 타입이 배열보다 문자열이 적합할 때 => 코딩테스트
		
		// 다만 토크나이저는 내부적으로는 legacy class 이므로 프로젝트에는 사용x
		
		// Scanner의 useDelimiter 메서드
		Scanner sc = new Scanner("100,200,300,400").useDelimiter(",");
		
	}

}
