package no04_String;

public class Ex05_Char {

	public static void main(String[] args) {
		// Char to Int : https://dlee0129.tistory.com/230
		
		// �ڵ� ����ȯ, ���� ����ȯ (X) : �ƽ�Ű �ڵ�� ��µǹǷ�
		
		// 1. '0' ���ֱ� (�ƽ�Ű �ڵ� Ȱ��. '0'�� �ƽ�Ű�ڵ� 48�� ���ָ� �¾�)
		char ch = '1';
		int n = ch - '0';
		System.out.println(n);
		
		// 2. Character.getNumericValue() (��α׿����� �̰� ��õ��)
		char ch2 = '2';
		int m = Character.getNumericValue(ch2);
		System.out.println(m);

	}

}
