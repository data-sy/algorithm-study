package no04_String;

import java.util.Arrays;

public class Ex02_메서드 {

	public static void main(String[] args) {

		String str = "Hello World";
		String str2 = "       Hello    World       ";
		
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
		System.out.println("===== toLowerCase, toUpperCase  : 소/대문자로 변환 =====");
		System.out.println(str.toLowerCase());
		System.out.println(str.toUpperCase());
		System.out.println("===== trim : 앞 뒤 공백 제거 (내부는 x) =====");
		System.out.println(str2.trim());
		
		System.out.println("===== split(구분자) : 구분자를 기준으로 나눈 것을 배열로 반환 =====");
		String[] splitStr = str.split(" ");
		for(int i = 0; i<splitStr.length; i++ ) {
			System.out.println(splitStr[i]);			
		}		
		System.out.println("===== toCharArray() : String을 char 배열로 반환 =====");
		// cf. toCharArray는 처리속도가 느려서 charAt을 사용하는 편 (출처 : https://woogienote.tistory.com/22)
		char[] charArr = str.toCharArray();
		System.out.println(Arrays.toString(charArr));
		for(char c : charArr ) {
			System.out.print(c + "//");
		}
	}

}
