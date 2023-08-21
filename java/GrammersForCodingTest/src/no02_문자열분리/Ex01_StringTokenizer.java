package no02_���ڿ��и�;

import java.util.StringTokenizer;

public class Ex01_StringTokenizer {

	public static void main(String[] args) {
		
		// ��ó : https://velog.io/@effirin/Java-StringTokenizer��-Split-�޼���-����-����ұ�
		
		// StringTokenizer : ���ڿ��� ������(delimiter)�� �������� ��ū(token)���� �ڸ�
		
		// ������
			// 1�� : ���ڿ� (������ ����Ʈ : �����̽�( ), ��(\t), �ٹٲ�(\n), ĳ���� ����(\r), \f)
			// 2�� : ���ڿ�, ������
			// 3�� : ���ڿ�, ������, �����ڵ� ��ū���� ��������T/�ƴ���F
		
		// �޼���
			// nextToken() : ���� String : ��ü���� ���� ��ū ��ȯ
			// nextToken(String delim) : ���� String : delim �������� ���� ��ū ��ȯ
			// nextElement() : ���� Object : nextToken �޼���� ����������, ��ü�� ����
			// countTokens() : ���� int : ��ü ��ū�� ��
			// hasMoreTokens() : ���� boolean : ��ū�� �����ִ��� t/f

		
		String test = "Hello Java World !";
		StringTokenizer st = new StringTokenizer(test);
		
		while(st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
		System.out.println("==========");

		
		// ���� ���� ���ڸ� �����ڷ� ����ϸ� ������ �����ڰ� ��
        String test2 = "x=100*(200+300)/2";				// +, -, *, /, =, (, ) ������ ��� ������
        StringTokenizer st2 = new StringTokenizer(test2, "+-*/=()", true);
 
        while(st2.hasMoreTokens()){
            System.out.println(st2.nextToken());
        }       
        
	}

}
