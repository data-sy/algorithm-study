package no03_�ܼ����;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Ex01_BufferedWriter {

	public static void main(String[] args) throws IOException{
		
		// System.out.println(); ���� ����
		// �ڹٿ������� ���鼭 �����ϱ�
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String data = "test";
		bw.write(data);
		
		int num = 10;
		bw.write(num);
		bw.write(String.valueOf(num));
		
		bw.newLine();
		

	}

}
