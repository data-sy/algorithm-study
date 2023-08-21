package no04_Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Ex02_�޼��� {

	public static void main(String[] args) {

		int[] arr = {100, 10, 1000, 1, 10000};
		String[] arrStr = {"Hello", "Java", "World"};

		System.out.println("===== toString : String���� ��ȯ�ϴ� �ǵ� print�� for�� �� ������ �Ǵ� ������� ��� =====");
		System.out.println(Arrays.toString(arr)); // [100, 10, 1000, 1, 10000]
		
		System.out.println("===== sort : �������� ���� =====");
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr)); // [1, 10, 100, 1000, 10000]		
		System.out.println("===== binarySearch : (���ĵ� �迭�� ����) ����Ž�� =====");
		System.out.println(Arrays.binarySearch(arr, 10)); // 1

		System.out.println("===== copyOf(A, n) : A�� ���� n�� �迭�� ���� =====");
		String[] arrStr2 = Arrays.copyOf(arrStr, 5);
		System.out.println(Arrays.toString(arrStr2)); // ���� ���̴� �⺻������ �ʱ�ȭ
		System.out.println("===== copyOfRange(A, n, m) : A�� �ε��� n�̻� m�̸� �����̽��ؼ� ���� =====");
		int[] arr2 = Arrays.copyOfRange(arr, 1, 4);
		System.out.println(Arrays.toString(arr2)); // [10, 100, 1000]
	
		System.out.println("===== fill(A, a) : �迭 A�� Ư���� a�� �ʱ�ȭ =====");
		Arrays.fill(arr, 5);
		System.out.println(Arrays.toString(arr)); // [5, 5, 5, 5, 5]
		
	}

}
