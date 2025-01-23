package 상반;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex040 {

    public static void main(String[] args) throws IOException {
        // https://www.acmicpc.net/problem/1158

        // Queue 사용

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        sb.append('<');

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        while (!queue.isEmpty()) {
            for (int i = 1; i < K; i++) {
                queue.add(queue.poll());
            }
            sb.append(queue.poll()).append(", ");
        }

        sb.setLength(sb.length()-2);
        sb.append('>');

        System.out.println(sb);

    }

}
