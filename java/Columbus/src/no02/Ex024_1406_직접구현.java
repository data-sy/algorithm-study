package no02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex024_1406_직접구현 {

	public static void main(String[] args) throws IOException{
		// https://www.acmicpc.net/problem/1406
				
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		String str = br.readLine();
		// 입력 받은 문자열을 노드와 리스트로 구현 & 맨 뒤에 커서 추가
		Node cursor = new Node('C'); // 소문자를 제외한 아무거나? 아니면 아얘 아무거나 가능한가?
		
		int N = str.length();
		int M = Integer.parseInt(br.readLine());
		String cmd;
		char input;

		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			cmd = st.nextToken();
			if (st.hasMoreTokens()) input = st.nextToken().charAt(0); // 받은 String을 char로 형변환 
			switch(cmd) {
				case "L":
					break;
				case "D":
					break;
				case "B":
					break;
				case "P":
					break;
			}
		}
		// 만든 리스트에서 순서대로 출력해서 sb에 담아 => 이것도 메서드
		System.out.println(sb);
	}

}
class Node {
	Node prev;
	char data;
	Node next;
	
	public Node(char data){
		this.data = data;
		this.next = null;
		this.prev = null;
	}
	
	public void L() {
		// 커서의 next의 prev가 null이 아닐 때 
			// 커서의 next에 (커서의 next의 prev)를 담는다.
	}
	
	public void D() {
		// 커서의 next의 next가 null이 아닐 때 
			// 커서의 next에 (커서의 next의 next)를 담는다. 
		
	}
	public void B() {
		// 커서의 next의 prev가 null이 아닐 때 
			// tmp = 커서의 next의 next를 따로 빼두고 
			// 커서를 L로 이동
			// 커서의 next의 next에 tmp를 담고
			// tmp의 prev에 커서의 next를 담아 		
	}
	public void P(char input) {
		// newNode = new Node(input);
		// if : 맨 처음 시작할 때 (커서 외의 아무 노드도 없는 상태) = 커서에 next가 없을 때 
			// 뉴 노드를 커서의 next에 담기
		// else : 커서에 next가 있을 때 
			// 커서의 next.next가 null이면 tmp도 null이라서 그냥 해도 돼
			// 즉, 커서의 next next가 있을 때와 없을 때로 분기처리 해주지 않아도 됨 

			// tmp = 커서의 next의 next를 따로 빼두고 
			// next 처리 
				// 커서의 next.next에 newNode를 담고
				// newNode의 next에 tmp를 담고
			// prev 처리 
				// tmp의 prev에 newNode를 담고
				// newNode의 prev에 커서의 next를 담아 
			// 마지막으로 커서를 D

	}

}



