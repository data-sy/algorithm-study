package no06_Collection;

import java.util.LinkedList;
import java.util.Queue;

public class Ex06_Queue {

	public static void main(String[] args) {
		
		// 인터페이스
		// 상속구조 : Collection <- Queue <- LinkedList
		// 즉, LinkedList로 구현
		
		Queue<Integer> queue = new LinkedList<>();

		// 메서드 : add, remove, element, offer (예외 처리 기능 미포함)
				// offer, poll, peek (예외 처리 기능 포함 : 데이터가 없을 때 기본값(null)으로 대체)
		// add 만 java.util.Collection, 나머지는 java.util.Queue
		
		queue.add(1);
		queue.offer(2);
		queue.offer(3);
		System.out.println(queue.toString());  // 3
		System.out.println(queue.poll());  // 1
		System.out.println(queue.peek()); // 2
		System.out.println(queue.isEmpty()); // Collection의 메서드도 사용 가능 false
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.poll()); // 비어 있으면 오류x. null 반환
		System.out.println(queue.peek()); // 비어 있으면 오류x. null 반환
		
	}
}
