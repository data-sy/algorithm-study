package no01_콘솔입력;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Ex03_InputStreamReader {

	public static void main(String[] args) throws IOException {
		
		// InputStreamReader
		// 입력을 아스키코드값이 아닌 문자값 그대로 출력
        InputStream in = System.in;
        
        // InputStreamReader 객체 생성
        // InputStream 객체인 in을 입력인자로 가짐
        InputStreamReader reader = new InputStreamReader(in);
        
        char[] a = new char[3];
        reader.read(a);
        System.out.println(a);
        
        // 단점 : 여전히 고정된 길이로만 스트림을 읽음
        // 사용자가 엔터키를 입력할 때까지 사용자의 입력을 전부 받아들이고 싶어 => BufferedReader
	}

}
