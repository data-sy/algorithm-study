package no02_���ڿ��и�;

import java.util.Scanner;

public class Ex03_Split��Tokenizer���� {

	public static void main(String[] args) {
		
		// �� �� ���� �� �������� ���� ���� ��ó : https://velog.io/@effirin/Java-StringTokenizer��-Split-�޼���-����-����ұ� 

		// Split
			// ������� String[] �迭
			// �� ���ڿ� ��ū ��
			// ����ǥ������ ����ؾ� ��
		
		// Tokenizer
			// ������� String ���ڿ�
			// �� ���ڿ��� ��ū���� �ν� x
			// ���� : �����ڴ� �� ���ڷ�
			// ������ �ڸ��� ���� ���ڸ� ����ϸ� ������ �����ڰ� �� => �� ���� �̻��� �����ڴ� split ���
		
		// ���� ��ũ�������� ����ϳ�
			// �����ڿ� �����ڵ� x , �� ������ ��
			// ��ȯ Ÿ���� �迭���� ���ڿ��� ������ �� => �ڵ��׽�Ʈ
		
		// �ٸ� ��ũ�������� ���������δ� legacy class �̹Ƿ� ������Ʈ���� ���x
		
		// Scanner�� useDelimiter �޼���
		Scanner sc = new Scanner("100,200,300,400").useDelimiter(",");
		
	}

}
