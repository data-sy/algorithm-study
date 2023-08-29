package chapter03_자료구조;

public class Ex000_test {

	public static void main(String[] args) {
//		int add = Add(1, 2);
//		System.out.println(add);
//		
//		int a = 1;
//		int[] arr = {0, 1, 2, 3};
//		int add1 = Add10(arr[a++]);
//		System.out.println(add1);
//		System.out.println(a);
		int i = 4, j = 2;
		// t, f 에 상관없이 무조건 ++는 되긴 함
		while(i == j++) {
			System.out.println("i : " + i);
			System.out.println("j : " + j);

		}
		System.out.println("i : " + i);
		System.out.println("j : " + j);
	}
//	private static int Add(int a, int b) {
//		return a+b;
//	}
//	private static int Add10(int a) {
//		return a+10;
//	}

}
