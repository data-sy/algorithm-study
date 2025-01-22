package 상반;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Ex039 {

    public static void main(String[] args) throws IOException {
        // https://www.acmicpc.net/problem/2164

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        int n = 1;
        while (!queue.isEmpty()) {
            n = queue.poll();
            if (!queue.isEmpty()) queue.add(queue.poll());
        }
        System.out.println(n);

    }

}
