package no03_�ܼ����;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Ex01_BufferedWriter {

	public static void main(String[] args) throws IOException{
		// System.out.println(); ���� ����
		
		// ��ó : https://steady-coding.tistory.com/184 + ����..
		
		// throws IOException ����ó�� �ʼ�
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));	
		String data = "test";
		int num = 10;		

		// write : ����� ���� ���ۿ� ���
			// �ڵ������� �����Ƿ� ������ ���Ҷ��� �̽������� ����ϰų�
		bw.write(data +"\n");
		
		// int�� �Էµ��� ���� (�� ĭ���� ���?)
		bw.write(num);
		bw.write(String.valueOf(num*10));
		
		// newLine : �� �� �ۼ� = ����
		bw.newLine();
		bw.write(data);
		// flush : ���۸� ���� ���ÿ� �ֿܼ� ���
		// close : ��Ʈ�� ����
		// ���۸� ��Ƴ������Ƿ� flush() or close()�� �ݵ�� ȣ���Ͽ� ��ó��
		bw.flush();
		bw.close();

		
		// �ڹ� ���� ���� 834p �⺻�� ���ڼ��� UTF-8�� ��Ȳ���� MS949 ���ڼ� �ؽ�Ʈ ���� �б�

	}

}
