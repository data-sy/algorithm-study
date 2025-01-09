package 상반;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex022 {

    public static void main(String[] args) throws IOException {
        // https://www.acmicpc.net/problem/1966

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            Queue<Doc> queue = new LinkedList<>();
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                queue.add(new Doc(j, Integer.parseInt(st.nextToken())));
            }
            int cnt = 0;
            while (true) {
                // max 찾기
                int maxPriority = 1;
                for (int j = 0; j < queue.size(); j++) {
                    Doc doc = queue.poll();
                    if (maxPriority < doc.priority) {
                        maxPriority = doc.priority;
                    }
                    queue.add(doc);
                }
                // max 프린트
                Doc printedDoc;
                while (true) {
                    Doc doc = queue.poll();
                    if (doc.priority == maxPriority) {
                        printedDoc = new Doc(doc.index, doc.priority);
                        break;
                    }
                    queue.add(doc);
                }
                cnt++;
                // 프린트한 문서가 M번 문서이면 break;
                if (printedDoc.index == M) break;
            }
            sb.append(cnt).append('\n');

        }
        System.out.println(sb);

    }

    static class Doc {
        private int index;
        private int priority;

        public Doc(int index, int priority) {
            this.index = index;
            this.priority = priority;
        }

    }

}
