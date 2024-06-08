package no06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Ex028_12851_숨바꼭질2_시도들 {
    static int K;
    static int[] visited; // 방문한 곳은 그 때의 시간 기록
    static ArrayDeque<Integer> q;
    static boolean isFind;
    static int now;
    static int time;
    static int cnt;

    public static void main(String[] args) throws IOException {
        // https://www.acmicpc.net/problem/12851

        // +1, -1, *2 한 결과를 큐에 담아서 bfs 돌리기
        // K를 한 번 찾고 나면
            // 더 이상 add 할 필요 없이 cnt만 ++
            // 정답과 같은 층위에 들어서면 break

        // N==K 일 때는 0, 1로 끝

        // 32%쯤에서 틀림
            // if (isFind && visited[now]>time) 로는 break문이 잘 작동하지 않아서
            // >가 아니라 == 일 때야! time과 같은 계층일 때 더 이상 next를 볼 필요 없어지므로!

        // 42%에서 틀림
            // 점의 위치가 0~100000 라는 게 아니야 (그냥 들어오는 점의 범위가 0~100000인 거지, 위치할 수 있는 공간이 0~100000라는 게 아니야!!)
            // 근데 어차피 K가 양수라서 음수 값이 나오면 의미 없긴 해 => 음수는 필터링 주자
            // 점의 범위가 2배로 커지는 건 감당해야 해! 거기서 더 짧은 길이 나올 수 있으니까 => 100,002까지는 사용 가능하도록
                // 손필기 참조
                // [-1 -> *2] vs [*2 -> -1 -> -1] : 값은 같은데 왼쪽이 최단
                // [+1 -> *2] vs [*2 -> +1 -> +1] : 값은 같은데 왼쪽이 최단
                // [-1 -> *2배 -> +1] vs [*2 -> -1] : 값은 같은데 오른쪽이 최단
                // 즉, 2배의 -1까지는 감당할 수 있어야 해!
            // 예) 50000 99999
            // 정답) 2 1 (2배하고 -1)
            // 예) 50001 100000
            // 정답) 2 1 (-1하고 2배)
            // 하지만 어쨌든 큐에 50002 100002 49999 가 담기긴 해! (거리를 넘겨서 poll 하기 전에 break걸릴 뿐)
        // 즉, 숫자 100002는 감당할 수 있어야 해
// !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!아니야!!!!!!!!!!!1!!!!!!!!!!!!!!!!!!!!!!!!
        // 큐에 담기는 건 괜찮아. 어차피 최단 경로에 영향을 안 미치는 숫자야.
        // 즉, 100002를 최단경로로 사용하는 경우는 없다!
        // 100000으로 해도 됨!

        // 46%에서 틀림
            // 사용된 순간 바로 visited를 하면 안 되나? 같은 층위에서 중복 나올 수 있어서??
            // 예) 5에서
            // 1층 (4, 6, 10)
            // 2층 (3, 8, 7, 12, 9, 11, 20)
            // 3층 (2, 16, 14, 13, 24, 18, 22, 19, 21, 40)
            // 여기까지는 같은 층위에 같은 숫자가 나오지 않았기 때문에 처음 나왔을 때 바로 visited 처리 해도 됐었어
            // 4층 (1, 15, 17, 32, ✓15✓, 28, 26, 23, 25, 48, 36, ✓23✓, 44, 38, 42, 39, 41, 80)
            // 내가 한 처리로는 같은 층위의 중복은 사라짐
            // 1 15 17 32 ✓ 28 26 23 25 48 36 ✓ 44 38 42 39 41
        // 그래서 최단거리만 구할 때는 이 풀이로 괜찮았는데 (숨바꼭질1)
        // 최단거리 개수를 카운트하려는 순간 없애버린 경로가 문제가 돼

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
                if (isFind && visited[now]==time) break;
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
        // time==0은 방문한 적이 없는 것
        if ( 0<=N && N<=100002 && visited[N]==0) {
            q.add(N);
            visited[N] = visited[now]+1;
        }
    }

}
