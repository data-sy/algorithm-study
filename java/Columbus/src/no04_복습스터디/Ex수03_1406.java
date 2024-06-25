package no04_복습스터디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Ex수03_1406 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int M = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		LinkedList<Character> lStack = new LinkedList<>();
		Stack<Character> rStack = new Stack<>();
		for (int i=0; i<str.length(); i++){
			lStack.push(str.charAt(i));
		}

		for (int i=0; i<M; i++){
			st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();
			Character input = null;
			if (cmd.equals("P")) input = st.nextToken().charAt(0);
			switch (cmd) {
				case "L" :
					if (!lStack.isEmpty()) rStack.push(lStack.pop());
					break;
				case "D" :
					if (!rStack.isEmpty()) lStack.push(rStack.pop());
					break;
				case "B" :
					if (!lStack.isEmpty()) lStack.pop();
					break;
				case "P" :
					lStack.push(input);
					break;
			}
		}
		while(!lStack.isEmpty()){
			sb.append(lStack.pollLast());
		}
		while(!rStack.isEmpty()){
			sb.append(rStack.pop());
		}
		System.out.println(sb);

	}
}
