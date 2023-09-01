package no03_콘솔출력;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Ex01_BufferedWriter {

	public static void main(String[] args) throws IOException{
		// System.out.println(); 보다 빠름
		
		// 출처 : https://steady-coding.tistory.com/184 + 알파..
		
		// throws IOException 예외처리 필수
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));	
		String data = "test";
		int num = 10;		

		// write : 출력할 내용 버퍼에 담기
			// 자동개행이 없으므로 개행을 원할때는 이스케이프 사용하거나
		bw.write(data +"\n");
		
		// int는 입력되지 않음 (빈 칸으로 담김?)
		bw.write(num);
		bw.write(String.valueOf(num*10));
		
		// newLine : 빈 줄 작성 = 개행
		bw.newLine();
		bw.write(data);
		// flush : 버퍼를 비우는 동시에 콘솔에 출력
		// close : 스트림 닫음
		// 버퍼를 잡아놓았으므로 flush() or close()를 반드시 호출하여 뒷처리
		bw.flush();
		bw.close();

		
		// 자바 완전 정복 834p 기본값 문자셋이 UTF-8인 상황에서 MS949 문자셋 텍스트 파일 읽기

	}

}
