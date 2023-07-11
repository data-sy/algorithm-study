
public class Test {

	public static void main(String[] args) {
		
		// 문제 : 순서쌍의 개수
		
		// 실수와 정수 비교 => 가능
		int n = 10;
		double m = 10.0;
		if (n==m) System.out.println("가능");
		
		// 제곱수일 때 잘 파악하는지 확인 => 가능
		n = 100;
		double sqr = Math.sqrt(n);
		System.out.println("sqr : " + sqr);
		if ( sqr == (int)sqr) System.out.println("제곱수");
		else System.out.println("제곱수 아님");

		// double의 % 연산 결과 확인하기
		double a = 10.44;
		double b = 3.23;
		double c = a%b;
		double d = a/b;
		System.out.println("나머지 : "+ c);
		System.out.println("몫 : "+ d);
		// chatGPT의 설명 : 실수자료형은 % 연산 못함.
		// 부동소수점 값에 대한 나머지 연산을 원한다면 다음 방법을 사용해야 함
		// a를 b로 나눈 후 소수점을 버리고, 이를 b에 곱하여 a에서 빼준다.
		// a=b*몫+e 꼴과 같음
		double e = a-Math.floor(a/b)*b;
		System.out.println("나머지 맞음 : "+ e);

		
		
	}

}
