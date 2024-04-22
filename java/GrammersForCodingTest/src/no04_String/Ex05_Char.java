package no04_String;

public class Ex05_Char {

	public static void main(String[] args) {
		// Char to Int : https://dlee0129.tistory.com/230
		
		// 자동 형변환, 강제 형변환 (X) : 아스키 코드로 출력되므로
		
		// 1. '0' 빼주기 (아스키 코드 활용. '0'의 아스키코드 48을 빼주면 맞아)
		char ch = '1';
		int n = ch - '0';
		System.out.println(n);
		
		// 2. Character.getNumericValue() (블로그에서는 이걸 추천함)
		char ch2 = '2';
		int m = Character.getNumericValue(ch2);
		System.out.println(m);

	}

}
