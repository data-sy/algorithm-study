package no11_그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Ex030_12851_숨바꼭질_BFS {
    static int K;
    static int[] visited; // 방문한 곳은 그 때의 시간 기록
    static ArrayDeque<Integer> q;
    static boolean isFind;
    static int now;
    static int time;
    static int cnt;

    public static void main(String[] args) throws IOException {
        // https://www.acmicpc.net/problem/2667

        // +1, -1, *2 결과를 큐에 add해서 bfs 돌리기
        // K를 찾고 나면
            // 더 이상 add 할 필요 없이 cnt만 ++
            // 언제까지? 정답과 같은 층위가 나올 때 까지

        // 이번에도 오류 못 잡아서 ㅜ 저번 풀이 참고

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if (N==K) { // N==K일 때는 반복문 돌릴 필요 없이 바로 0초, 1개
            System.out.println(0);
            System.out.println(1);
        } else {
            visited = new int[100001];
            q = new ArrayDeque<>();
            q.add(N);
            visited[N]=1; // 방문하지 않음=0초 , 시작=1초 (맨 마지막에 -1)

            int next = 0;
            while(!q.isEmpty()) {
                now = q.poll();

                // 정답과 같은 층위의 now부터는 break
                if (isFind && visited[now]==time)  break;

                next = now - 1;
                if (!isFind) bfsAdd(next);  // 찾기 전에는 bfs
                else if (next==K) cnt++;    // 찾은 후에는 개수 세기

                next = now + 1;
                if (!isFind) bfsAdd(next);
                else if (next==K) cnt++;

                next = now * 2;
                if (!isFind) bfsAdd(next);
                else if (next==K) cnt++;

            }

            // 1초에서 시작했으니 -1
            System.out.println(time-1);
            System.out.println(cnt);
        }

    }
    static void bfsAdd(int N){
        if (N==K) {
            isFind = true;
            visited[N] = visited[now]+1; // break를 위해 담아줘야 해
            time = visited[N];
            cnt++;
            return;
        }

        // 범위를 벗어나면 리턴
        if ( N<0 || 100000< N ) return;

        if (visited[N]==0) { // 기존 BFS
            q.add(N);
            visited[N] = visited[now]+1;
            // 방문했더라도 같은 층위라면 큐에 add
        } else if (visited[N] == visited[now]+1) q.add(N);

    }

}
