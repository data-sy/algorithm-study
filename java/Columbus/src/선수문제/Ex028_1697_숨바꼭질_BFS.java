package 선수문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Ex028_1697_숨바꼭질_BFS {
    static int K;
    static int[] visited; // 방문한 곳은 그 때의 시간 기록
    static ArrayDeque<Integer> q;
    static boolean isFind;
    static int now;
    static int time;

    public static void main(String[] args) throws IOException {
        // https://www.acmicpc.net/problem/1697

        // 우선 시간만 출력!
        // 이 아이디어는 맞아!

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if (N==K) {
            System.out.println(0);
        } else {
            visited = new int[100003];

            q = new ArrayDeque<>();
            q.add(N);
            visited[N]=1;

            int next = 0;
            while(!q.isEmpty()) {
                now = q.poll();
                // -
                next = now - 1;
                if (!isFind) bfsAdd(next);
                else break;
                // +
                next = now + 1;
                if (!isFind) bfsAdd(next);
                else break;
                // *
                next = now * 2;
                if (!isFind) bfsAdd(next);
                else break;
            }
            // visted를 위해 N일 때 1초에서 시작했으니 time-1
            System.out.println(time);
        }

    }
    static void bfsAdd(int N){
        if (N==K) {
            isFind = true;
            time = visited[now];
            return;
        }
        // time==0은 방문한 적이 없는 것
        if ( 0<=N && N<=100002 && visited[N]==0) {
            q.add(N);
            visited[N] = visited[now]+1;
        }
    }

}
