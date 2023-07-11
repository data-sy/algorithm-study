package no01_콘솔입력;

import java.io.IOException;
import java.io.InputStream;

public class Ex02_InputStream {

	public static void main(String[] args) throws IOException {
		// 스트림(Stream)이란?
		// 수도꼭지. 수도꼭지를 틀면 물이 나오고 수도꼭지를 잠그면 물이 나오지 않는다.
		// 스트림은 A수도관에서 B수도관으로 이동하는 물의 흐름
			// 파일 데이터 (파일은 그 시작과 끝이 있는 데이터의 스트림이다.)
			// HTTP 송수신 데이터 (브라우저가 요청하고 서버가 응답하는 HTTP 형태의 데이터도 스트림이다.)
			// 키보드 입력 (사용자가 키보드로 입력하는 문자열은 스트림이다.)
        InputStream in = System.in;

        int a;
        int b;
        int c;
        
//        // abc를 입력하면 각 스트림에 1byte 씩 차례대로 들어감
//        a = in.read();
//        b = in.read();
//        c = in.read();
//
//        System.out.println(a);
//        System.out.println(b);
//        System.out.println(c);
        
        // read 메서드의 입력값으로 길이 3짜리 byte 배열
        byte[] arr = new byte[3];
        in.read(arr);

        System.out.println(arr[0]);
        System.out.println(arr[1]);
        System.out.println(arr[2]);
        
        // 단점 : 읽어들인 값을 항상 아스키코드 값으로 해석해야 함
        // 입력한 문자값을 그대로 출력하고 싶어 => InputStreamReader
	}

}
