package no04_String;

import java.util.Arrays;

public class Ex02_메서드 {

	public static void main(String[] args) {

		String str = "Hello World";
		String str2 = "       Hello    World       ";
		String str3 = "a:b:c";
		
		System.out.println("===== startsWith/endswith : 문자열이 특정 문자로 시작되는지/끝나는지 판별 =====");
		System.out.println(str.startsWith("H")); // T
		System.out.println(str.startsWith("h")); // F	
		System.out.println(str.endsWith("d")); // T
		System.out.println(str.endsWith("D")); // F
		System.out.println("===== contains : 특정 문자열 포함되어 있는지 판별 =====");
		System.out.println(str.contains("Hello")); // T
		System.out.println(str.contains("Hi")); // F	
		System.out.println("===== equals : 문자열 값 비교 =====");
		System.out.println(str.equals("Hello World")); // T
		System.out.println(str.equals("hello world")); // F
		
		
		System.out.println("===== indexOf : 인덱스 위치 찾기 =====");
		System.out.println(str.indexOf("o")); // 4
		System.out.println(str.indexOf("W")); // 6
		System.out.println(str.indexOf(" ")); // 5
		System.out.println(str.indexOf("a")); // 없으면 -1 반환
		System.out.println("===== charAt : 인덱싱 =====");
		System.out.println(str.charAt(0)); // H
		System.out.println(str.charAt(9)); // l
		//System.out.println(str.charAt(20)); // 인덱스 크기를 넘기면 에러
		System.out.println("===== substring : 슬라이싱 =====");
		System.out.println(str.substring(4)); // o World
		System.out.println(str.substring(3, 7)); // lo W
		
		
		System.out.println("===== replace(A, B) : A를 B로 치환 =====");
		System.out.println(str.replace("Hello", "Hi")); // Hi World
		System.out.println(str); // 원래 문자열이 바뀌지는 않음  Hello World
		System.out.println(str.replaceAll(" ", "")); // HelloWorld
		System.out.println("abcdefdef".replaceAll("^abc|def$", ""));
		System.out.println("===== toLowerCase, toUpperCase  : 소/대문자로 변환 =====");
		System.out.println(str.toLowerCase());
		System.out.println(str.toUpperCase());
		System.out.println("===== trim, strip : 앞 뒤 공백 제거 (내부는 x) =====");
		System.out.println(str2.trim());
		System.out.println(str2.strip());
		System.out.println(str2.stripLeading());
		System.out.println(str2.stripTrailing());
		
		
		System.out.println("===== split(구분자) : 구분자를 기준으로 나눈 것을 배열로 반환 =====");
		String[] splitStr = str.split(" ");
		for(int i = 0; i<splitStr.length; i++ ) {
			System.out.println(splitStr[i]);			
		}
		String[] splitStr3 = str3.split(":");
		for(int i = 0; i<splitStr3.length; i++ ) {
			System.out.println(splitStr3[i]);			
		}
		
		// join 추가하기 
		
		System.out.println("===== toCharArray() : String을 char 배열로 반환 =====");
		// cf. toCharArray는 처리속도가 느려서 charAt을 사용하는 편 (출처 : https://woogienote.tistory.com/22)
		char[] charArr = str.toCharArray();
		System.out.println(Arrays.toString(charArr));
		for(char c : charArr ) {
			System.out.print(c + "//");
		}
		
		// compareTo()
		System.out.println("===== compareTo() : 크기 비교 결과를 int로 반환 =====");
		// 숫자형 (Integer) : (a, b)에서 a가 b보다 크다 (1), 같다(0), 작다(-1)
		Integer x = 2;
		Integer y = 3;
		Integer z = 2;
		System.out.println(x.compareTo(1)); // 1
		System.out.println(x.compareTo(z)); // 0
		System.out.println(x.compareTo(y)); // -1
			// int 사용하려면 compare로 
		System.out.println(Integer.compare(2, 1)); // 1
		System.out.println(Integer.compare(1, 1)); // 0
		System.out.println(Integer.compare(1, 2)); // -1
		// 문자형
			// 첫번째 문자부터 순서대로 비교 
			// 문자가 쭉 같아 (즉, 비교대상에 포함되어 있을 때) : 문자열 길이의 차이값 반환
				// 즉, 문자열이 완전히 같으면 0 반환 
        System.out.println( "abcd".compareTo("abcd") );  // 0
        System.out.println( "abcd".compareTo("ab") );  //  2
        System.out.println( "abcd".compareTo("a") );  //  3
        System.out.println( "abcd".compareTo("") );  //  4 
        	// 문자가 다른 경우 나오면 : 두 char의 아스키코드 값의 차이값 리턴
        System.out.println( "abcd".compareTo("c") );  //  -2 (a와 c의 아스키 차이값 97-99=-2 리턴)
        System.out.println( "abcd".compareTo("ac") );  //  -1 (b와 c)
        System.out.println( "abcd".compareTo("A") );  //  32 (a 97와 A 65) 
        // 대소문자 무시하고 비교 : compareToIgnorecase()
    	System.out.println( "a".compareToIgnoreCase("A") );  // 0	 
	}

}
