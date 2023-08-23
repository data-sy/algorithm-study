package no03_콘솔출력;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Ex01_BufferedWriter {

	public static void main(String[] args) throws IOException{
		
		// System.out.println(); 보다 빠름
		// 자바완전정복 보면서 정리하기
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String data = "test";
		bw.write(data);
		
		int num = 10;
		bw.write(num);
		bw.write(String.valueOf(num));
		
		bw.newLine();
		

	}

}
