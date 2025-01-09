package 상반;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex022_2 {

    public static void main(String[] args) throws IOException {
        // https://www.acmicpc.net/problem/1966

        // Doc 클래스 + poll한 doc보다 우선순위 큰 것 있는지 점검

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            Queue<Doc> queue = new LinkedList<>();
            for (int j = 0; j < N; j++) {
                queue.add(new Doc(j, Integer.parseInt(st.nextToken())));
            }

            int cnt = 0;
            while (true) {
                Doc target = queue.poll();

                boolean hasNoMax = true;
                for (Doc doc : queue) {
                    if (target.priority < doc.priority) {
                        hasNoMax = false;
                        break;
                    }
                }

                if (hasNoMax) {
                    cnt++;
                    if (target.index == M) break;
                } else queue.add(target);
            }
            sb.append(cnt).append('\n');

        }
        System.out.println(sb);

    }

    static class Doc {
        int index;
        int priority;

        public Doc(int index, int priority) {
            this.index = index;
            this.priority = priority;
        }

    }

}
