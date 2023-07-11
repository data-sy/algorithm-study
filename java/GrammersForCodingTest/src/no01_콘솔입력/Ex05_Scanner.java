package no01_콘솔입력;

// 이제 java.io가 아니라 java.util
import java.util.Scanner;

public class Ex05_Scanner {

	public static void main(String[] args) {
		
		// InputStream 객체인 System.in
        Scanner sc = new Scanner(System.in);
        
        // Scanner 객체의 next() 메서드는 단어 하나(Token)를 읽어들인다.
        // nextㅇㅇ() 으로 다양하게 읽어 들일 수 있음
        System.out.println(sc.next());

	}

}
