package chapter03_자료구조;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Ex013_카드게임_sol {
	public static void main(String[] args){

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		// Queue는 LinkedList로 구현
		Queue<Integer> queue = new LinkedList<>();
		for (int i=1; i<=N; i++) {
			queue.offer(i);
		}
		
		// size > 로 사용
		while(queue.size() > 1) {
			queue.poll();
			queue.offer(queue.poll());
		}
		// peek 말고 poll 사용
		System.out.println(queue.poll());

	}
}
