package no01_�ܼ��Է�;

// ���� java.io�� �ƴ϶� java.util
import java.util.Scanner;

public class Ex05_Scanner {

	public static void main(String[] args) {
		
		// InputStream ��ü�� System.in
        Scanner sc = new Scanner(System.in);
        
        // Scanner ��ü�� next() �޼���� �ܾ� �ϳ�(Token)�� �о���δ�.
        // next����() ���� �پ��ϰ� �о� ���� �� ����
        System.out.println(sc.next());

        // nextInt() �޼���� ������ �����ڷ� ����Ͽ� ���� ������ ã�� ��ȯ
        // 24 18 �Է� ��
		int n = sc.nextInt(); // 24
		int m = sc.nextInt(); // 18
	}

}
