package no00_아스키코드;

public class Ex01_charToInt {
	
	public static void main(String[] args) {
	
		// 아스키코드 이용해서 Char -> int
			// char - '0'
			// 같은 의미의 문자와 숫자의 코드 값 차이는 48 = '0' 이므로 
		char ch = '9';
		int n1 = ch - '0';
		System.out.println(n1); // 9
	
	}

}
