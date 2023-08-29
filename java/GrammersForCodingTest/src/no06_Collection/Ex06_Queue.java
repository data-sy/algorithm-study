package no06_Collection;

import java.util.LinkedList;
import java.util.Queue;

public class Ex06_Queue {

	public static void main(String[] args) {
		
		// �������̽�
		// ��ӱ��� : Collection <- Queue <- LinkedList
		// ��, LinkedList�� ����
		
		Queue<Integer> queue = new LinkedList<>();

		// �޼��� : add, remove, element, offer (���� ó�� ��� ������)
				// offer, poll, peek (���� ó�� ��� ���� : �����Ͱ� ���� �� �⺻��(null)���� ��ü)
		// add �� java.util.Collection, �������� java.util.Queue
		
		queue.add(1);
		queue.offer(2);
		queue.offer(3);
		System.out.println(queue.toString());  // 3
		System.out.println(queue.poll());  // 1
		System.out.println(queue.peek()); // 2
		System.out.println(queue.isEmpty()); // Collection�� �޼��嵵 ��� ���� false
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.poll()); // ��� ������ ����x. null ��ȯ
		System.out.println(queue.peek()); // ��� ������ ����x. null ��ȯ
		
	}
}
