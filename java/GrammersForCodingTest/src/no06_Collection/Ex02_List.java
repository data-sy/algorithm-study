package no06_Collection;

import java.util.List;
import java.util.Vector;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Ex02_List {

	public static void main(String[] args) {
		
		// List�� �������̽��̹Ƿ� ����Ŭ����(ArrayList, Vector, LinkedList) �����ڷ� ���� �÷��� ��ü ����
		List<String> arrList = new ArrayList<String>();
		List<String> vecList = new Vector<String>();
		List<String> linkedList = new LinkedList<String>();
		
		// Arrays.asList�� ���� �÷��� ��ü ����
		List<Integer> list = Arrays.asList(1, 2, 3, 4);
			// �߰� add, ���� remove �Ұ�. ������ set�� ����
			// ������ ���� �������� �� ��� (��) ���� ��~�� )
		
		// �޼���
		// ���� ���� ���Ǵ� ArrayList�� ������ 
			// �߰� add(A), add(n, A)
		System.out.println("===== add : ����Ʈ ���� ���� �߰� =====");
		arrList.add("one");
		arrList.add("two");
		arrList.add("three");
			// �� ���� ��� toString
		System.out.println(arrList.toString());
		System.out.println();
		System.out.println("===== add(n, A) : �ε��� n�� ���� A �߰� =====");
		arrList.add(2, "two2");
		System.out.println(arrList.get(2)); //two2
		
			// ���� set(n, A)
			// ���� remove(n), remove(A), clear()
		
			// ���� get(n)
		System.out.println("===== get(n) : �ε��� n�� ���� ��ȯ =====");
		System.out.println(arrList.get(3)); // three
		
			// ���� ���� size()
			// ����ִ��� ���� isEmpty()
		
			// �迭�� ��ȯ toArray()
			// Ư�� Ÿ������ �ٿ�ĳ���� toArray(T[] t)
		System.out.println("===== toArray() : Object �迭�� ��ȯ =====");
		String[] strArr = arrList.toArray(new String[0]); // list�� ũ�⸦ �츮�� ���� 0 ���

		// Vector
			// ����ȭ �޼���� �����Ǿ� ����. ��Ƽ �����忡 ����
		
		// LinkedList
			// ArrayList�ʹ� ���������� �����͸� �����ϴ� ����� �ٸ���.
				// �ε����� �����ϴ� �� �ƴ϶�, linked�� ����
			// �߰�, ���������� Linked�� �� ���� ����
			// �˻������� array�� �� ���� ����
	}

}
