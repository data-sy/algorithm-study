package no07_Math;

public class Ex02_계산테스트 {
	public static void main(String[] args) {
		
	// �Ǽ��� ���� �� => ����
	int n = 10;
	double m = 10.0;
	if (n==m) System.out.println("����");
	
	// �������� �� �� �ľ��ϴ��� Ȯ�� => ����
	n = 100;
	double sqr = Math.sqrt(n);
	System.out.println("sqr : " + sqr);
	if ( sqr == (int)sqr) System.out.println("������");
	else System.out.println("������ �ƴ�");

	// double�� % ���� ��� Ȯ���ϱ�
	double a = 10.44;
	double b = 3.23;
	double c = a%b;
	double d = a/b;
	System.out.println("������ : "+ c);
	System.out.println("�� : "+ d);
	// chatGPT�� ���� : �Ǽ��ڷ����� % ���� ����.
	// �ε��Ҽ��� ���� ���� ������ ������ ���Ѵٸ� ���� ����� ����ؾ� ��
	// a�� b�� ���� �� �Ҽ����� ������, �̸� b�� ���Ͽ� a���� ���ش�.
	// a=b*��+e �ð� ����
	double e = a-Math.floor(a/b)*b;
	System.out.println("������ ���� : "+ e);
	
	}
}
