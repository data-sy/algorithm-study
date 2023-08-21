package no02_문자열분리;

import java.util.StringTokenizer;

public class Ex01_StringTokenizer {

	public static void main(String[] args) {
		
		// 출처 : https://velog.io/@effirin/Java-StringTokenizer와-Split-메서드-언제-써야할까
		
		// StringTokenizer : 문자열을 구분자(delimiter)를 기준으로 토큰(token)으로 자름
		
		// 생성자
			// 1개 : 문자열 (구분자 디폴트 : 스페이스( ), 탭(\t), 줄바꿈(\n), 캐리지 리턴(\r), \f)
			// 2개 : 문자열, 구분자
			// 3개 : 문자열, 구분자, 구분자도 토큰으로 간주할지T/아닐지F
		
		// 메서드
			// nextToken() : 리턴 String : 객체에서 다음 토큰 반환
			// nextToken(String delim) : 리턴 String : delim 기준으로 다음 토큰 반환
			// nextElement() : 리턴 Object : nextToken 메서드와 동일하지만, 객체를 리턴
			// countTokens() : 리턴 int : 전체 토큰의 수
			// hasMoreTokens() : 리턴 boolean : 토큰이 남아있는지 t/f

		
		String test = "Hello Java World !";
		StringTokenizer st = new StringTokenizer(test);
		
		while(st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
		System.out.println("==========");

		
		// 여러 개의 문자를 구분자로 사용하면 각각이 구분자가 됨
        String test2 = "x=100*(200+300)/2";				// +, -, *, /, =, (, ) 각각이 모두 구분자
        StringTokenizer st2 = new StringTokenizer(test2, "+-*/=()", true);
 
        while(st2.hasMoreTokens()){
            System.out.println(st2.nextToken());
        }       
        
	}

}
