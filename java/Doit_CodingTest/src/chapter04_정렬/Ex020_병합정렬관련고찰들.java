package chapter04_정렬;

public class Ex020_병합정렬관련고찰들 {
	public static void main(String[] args) {
		int s, e, m, m2;

		// (s+e)/2와 s+(e-s)/2는 동일한 결과!!!
//		s = 0;
//		e = 8;
//		m = s + (e-s)/2;
//		System.out.println("처음 m : " + m);
//		
//		s = 0;
//		e = 4;
//		m = s + (e-s)/2;
//		System.out.println("짝수일 때 m : " + m);		
//
//		s = 5;
//		e = 8;
//		m = s + (e-s)/2;
//		int m2 = (s+e)/2;
//		System.out.println("홀수일 때 m : " + m);		
//		System.out.println("홀수일 때 m2 : " + m2);
		
		// s와 e가 같을 때는? => 여전히 같아!
		s = 2;
		e = 2;
		m = s + (e-s)/2;
		m2 = (s+e)/2;
		System.out.println("m : " + m);		
		System.out.println("m2 : " + m2);
	}
}
