package no06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Ex028_12851_숨바꼭질2_BFS {
    static int K;
    static int[] visited; // 방문한 곳은 그 때의 시간 기록
    static ArrayDeque<Integer> q;
    static boolean isFind;
    static int now;
    static int time;
    static int cnt;

    public static void main(String[] args) throws IOException {
        // https://www.acmicpc.net/problem/12851

        // bfsAdd에서
            // visited가 0인 것만(방문하지 않은 것만) 선택하는 게 아니라
            // visited가 visited[now]+1(현재 층위)일 때도 다시 넣어줘야 해

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if (N==K) {
            System.out.println(0);
            System.out.println(1);
        } else {
            visited = new int[100003];

            q = new ArrayDeque<>();
            q.add(N);
            visited[N]=1;

            int next = 0;
            while(!q.isEmpty()) {
                now = q.poll();
//                // 디버깅
//                if (isFind) {
//                    System.out.println("찾은 뒤 큐 내용물 확인");
//                    System.out.print(now + " ");
//                    q.forEach(e -> System.out.print(e + " "));
//                    System.out.println();
//                    System.out.println("걔들의 visited는");
//                    System.out.print(visited[now] + " ");
//                    q.forEach(e -> System.out.print(visited[e] + " "));
//                    System.out.println();
//                    break;
//                }
                // 정답과 같은 층위의 now부터는 더 이상 점검할 필요 없으므로 break
                if (isFind && visited[now]==time) {
//                    System.out.println("멈추는 순간은 : " + now);
                    break;
                }
                // -
                next = now - 1;
                if (!isFind) bfsAdd(next);
                else if (next==K) cnt++;
                // +
                next = now + 1;
                if (!isFind) bfsAdd(next);
                else if (next==K) cnt++;
                // *
                next = now * 2;
                if (!isFind) bfsAdd(next);
                else if (next==K) cnt++;
            }

            // visted를 위해 N일 때 1초에서 시작했으니 time-1
            System.out.println(time-1);
            System.out.println(cnt);
        }

    }
    static void bfsAdd(int N){
        if (N==K) {
            isFind = true;
            visited[N] = visited[now]+1;
            time = visited[N];
            cnt++;
            return;
        }
        // 범위를 벗어나면 리턴
        if ( N<0 || 100002< N ) return;
        if ( visited[N]==0 ) {
            q.add(N);
            visited[N] = visited[now]+1;
        } else if (visited[N] == visited[now]+1) q.add(N);
    }

}
