package no06_Collection;

import java.util.Stack;

public class Ex05_Stack {

	public static void main(String[] args) {
		// �÷��� �� �����ϰ� Ŭ����(�ٸ� �ֵ��� �������̽�). ��, ��ü������ ��ü ���� ����
		// ��ӱ��� : List <- Vector <- Stack
		Stack<Integer> stack = new Stack<>();
		
		// �޼��� : Vector�� ��� ��� + LIFO ������ ���� 5���� �޼���
			// Vector�� �޼��� add, remove ���� ����� �� ������ LIFO�� Ư�� �ݿ� x
		
		// 5�� �޼��� : push, pop, peek, search, isEmpty
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		System.out.println(stack.pop());  // 5
		System.out.println(stack.peek()); // 4
		System.out.println(stack.search(2)); // 3
		System.out.println(stack.search(10)); // ������ -1
		System.out.println(stack.isEmpty()); // false
		stack.pop();
		stack.pop();
		stack.pop();
		stack.pop();
		System.out.println(stack.isEmpty()); // true

		// ������ ������� �� �� �� �ִ� ������ ������
		
		// ������ ��� �ִ� ���¿��� pop, peek
//		stack.pop(); // Exception in thread "main" java.util.EmptyStackException
//		stack.peek(); // Exception in thread "main" java.util.EmptyStackException
		// ������ ������� �� pop �ϵ��� ����
		if (!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
	}

}
