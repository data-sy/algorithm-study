package no04_String;

public class Ex04_StringBuffer {

	public static void main(String[] args) {
		
		
		// StringBuffer : ���ڿ��� �߰��ϰų� ������ �� �ַ� ����ϴ� �ڷ���
		// �޼��� : append, insert, substring
		
		StringBuffer sb = new StringBuffer();
		sb.append("hello");
		sb.append(" ");
		sb.append("world!");
		sb.append("\n");  // �ٹٲ�
		sb.append("Hi");
		// append�� ���ڿ��� ��� �߰��ϴٰ� �������� toString���� ���ڿ� ��ȯ
		String result = sb.toString();
		System.out.println(result); 
	
		// String ���δ� += �� ����
		String str = "hello";
		str += " ";
		str += "world";
		
		// String���� ����
		// string : �߰�, ������ ������ ��ü ���� (�̹��ͺ�(immutable)�ϴ�)
		// StringBuffer�� ��ü �� �� ���� (���ͺ�(mutable)�ϴ�)
			// �ٸ�, StringBuffer�� �� ���ſ� �ڷ���
		// ��� 
			// ���ڿ� �߰�,���� �۾��� ������ -> StringBuffer
			// ������ -> String�� ����ϴ� ���� ����
			
		
		// insert
		sb.insert(0, "�� �� ");
		result = sb.toString();
		System.out.println(result);		
		
		// substring : String�� substring�� ���� (�����̽� ���)
		System.out.println(sb.substring(1, 6));
		
	}

}
