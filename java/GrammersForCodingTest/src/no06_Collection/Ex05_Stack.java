package no06_Collection;

import java.util.Stack;

public class Ex05_Stack {

	public static void main(String[] args) {
		// 컬렉션 중 유일하게 클래스(다른 애들은 인터페이스). 즉, 자체적으로 객체 생성 가능
		// 상속구조 : List <- Vector <- Stack
		Stack<Integer> stack = new Stack<>();
		
		// 메서드 : Vector의 모든 기능 + LIFO 구조를 위한 5개의 메서드
			// Vector의 메서드 add, remove 등을 사용할 수 있지만 LIFO의 특성 반영 x
		
		// 5개 메서드 : push, pop, peek, search, isEmpty
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		System.out.println(stack.pop());  // 5
		System.out.println(stack.peek()); // 4
		System.out.println(stack.search(2)); // 3
		System.out.println(stack.search(10)); // 없으면 -1
		System.out.println(stack.isEmpty()); // false
		stack.pop();
		stack.pop();
		stack.pop();
		stack.pop();
		System.out.println(stack.isEmpty()); // true

		// 스택이 비어있을 때 날 수 있는 오류들 모으기
		
		// 스택이 비어 있는 상태에서 pop, peek
//		stack.pop(); // Exception in thread "main" java.util.EmptyStackException
//		stack.peek(); // Exception in thread "main" java.util.EmptyStackException
		// 스택이 비어있을 때 pop 하도록 검증
		if (!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
	}

}
