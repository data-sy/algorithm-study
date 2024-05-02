package no02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex017_18258 {

	public static void main(String[] args) throws IOException{
		//https://www.acmicpc.net/problem/18258
		
		// 1. 라이브러리 사용
		// 2. LinkedList로 구현
		// 3. 배열로 구현
		
		// 라이브러리 사용 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(st.nextToken());
		
		// 인터페이스 Queue는 peekLask() 메서드 없음
		LinkedList<Integer> queue = new LinkedList<>();
		int n = 0;
		
		for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            if (st.hasMoreTokens())	n = Integer.parseInt(st.nextToken());
            switch(cmd) {
                case "push" : 
                	queue.add(n); 
                	break;
                case "pop" : 
                	if (!queue.isEmpty()) sb.append(queue.poll()+"\n");
                	else sb.append("-1\n");
                	break;
                case "size" : 
                	sb.append(queue.size()+"\n");
                	break;
                case "empty" : 
                	if (queue.isEmpty()) sb.append("1\n");
                	else sb.append("0\n");
                	break;
                case "front" : 
                	if (!queue.isEmpty()) sb.append(queue.peek()+"\n");
                	else sb.append("-1\n");
                	break;
                case "back" :
                	if (!queue.isEmpty()) sb.append(queue.peekLast()+"\n");
                	else sb.append("-1\n");
                	break;
            }
        }
        System.out.println(sb);
		
	}

}
