package no04_String;

public class Ex01_�ڷ�����ȯ {

	public static void main(String[] args) {
		
		// Integer.parseInt : String -> int
		int n = Integer.parseInt("100");
		System.out.println(n+100); // 100+100=200
		
			// ������ ��ȯ���� ���� : 2���� -> 10����
		int n2 = Integer.parseInt("1111", 2);
		System.out.println(n2); // 1+2+4+8=15

		
		// Integer.valueOf : String, int -> Integer
		String str = "50";
		System.out.println(Integer.valueOf(str)+50); //50+50=100
		int num = 100;
		System.out.println(Integer.valueOf(num).getClass().getName());

		// String.valueOf : double, char -> String
		System.out.println(String.valueOf(5.0).getClass().getName());
		System.out.println(String.valueOf('A').getClass().getName());
	
	}

}
