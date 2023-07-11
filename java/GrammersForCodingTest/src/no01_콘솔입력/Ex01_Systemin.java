package no01_콘솔입력;

import java.io.IOException;
import java.io.InputStream;

public class Ex01_Systemin {

	public static void main(String[] args) throws IOException {
		// 출처 : 점프 투 자바 https://wikidocs.net/226
		
		// System.in은 InputStream의 객체 (콘솔입력)
		// InputStream은 java.io 패키지의 바이트 단위 입력을 위한 최상위 입력 스트림 클래스입니다.
		InputStream in = System.in;

        int a;
        // read메서드 : 1 byte의 사용자의 입력을 받아들임
        // 저장되는 int 값은 0-255 사이의 정수값으로 아스키 코드값
        // 실행시키면 사용자의 입력을 받을 때까지 프로그램이 대기 (엔터 : 입력 종료)
        a = in.read();

        System.out.println(a);
		
		// cf. throws IOException
        // InputStream으로 부터 값을 읽어들일 때는 IOException 발생할 수 있음 => 예외 처리해야 함
		// throws로 그 예외처리를 뒤로 미룸

	}

}
