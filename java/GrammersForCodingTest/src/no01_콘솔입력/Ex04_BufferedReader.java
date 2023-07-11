package no01_콘솔입력;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Ex04_BufferedReader {

	public static void main(String[] args) throws IOException  {
		
		// InputStream, InputStreamReader 객체가 연쇄적으로 입력인자로 사용된		
        InputStream in = System.in;
        InputStreamReader reader = new InputStreamReader(in);
        BufferedReader br = new BufferedReader(reader);

        // BufferedReader의 readLine메서드
        String a = br.readLine();
        System.out.println(a);
        
        // InputStream - byte
        // InputStreamReader - character
        // BufferedReader - String
        
        // InputStream은 바이트를 읽고, InputStreamReader는 문자를 읽고,
        // BufferedReader는 문자열을 읽는다.

	}

}
