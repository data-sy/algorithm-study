package no04_String;

public class Ex04_StringBuffer {

	public static void main(String[] args) {
		
		
		// StringBuffer : 문자열을 추가하거나 변경할 때 주로 사용하는 자료형
		// 메서드 : append, insert, substring
		
		StringBuffer sb = new StringBuffer();
		sb.append("hello");
		sb.append(" ");
		sb.append("world!");
		sb.append("\n");  // 줄바꿈
		sb.append("Hi");
		// append로 문자열을 계속 추가하다가 마지막에 toString으로 문자열 변환
		String result = sb.toString();
		System.out.println(result); 
	
		// String 으로는 += 로 구현
		String str = "hello";
		str += " ";
		str += "world";
		
		// String과의 차이
		// string : 추가, 수정할 때마다 객체 생성 (이뮤터블(immutable)하다)
		// StringBuffer는 객체 한 번 생성 (뮤터블(mutable)하다)
			// 다만, StringBuffer가 더 무거운 자료형
		// 결론 
			// 문자열 추가,변경 작업이 많으면 -> StringBuffer
			// 적으면 -> String을 사용하는 것이 유리
			
		
		// insert
		sb.insert(0, "맨 앞 ");
		result = sb.toString();
		System.out.println(result);		
		
		// substring : String의 substring과 같음 (슬라이싱 기능)
		System.out.println(sb.substring(1, 6));
		
	}

}
