package no05;

import java.io.IOException;
import java.util.HashSet;

public class Ex000_013_순열재귀로 {

    static String[] arr;
    static int N;
    static boolean[] visited;
    static int K;
    static HashSet<String> set;

    public static void main(String[] args) throws IOException {
        // https://www.acmicpc.net/problem/5568

        // nPk : n개 중 k개를 순서있게 뽑아서 나열하기
        // 출처 : https://velog.io/@wp29dud/Java-%EC%88%9C%EC%97%B4-%EC%A1%B0%ED%95%A9-%EC%9E%AC%EA%B7%80
                // 비트 마스크?? 이거는 나중에 봐보자 https://namhandong.tistory.com/191
        // for문으로 순회하되, 이미 사용한 원소는 재사용하지 않도록 visited 배열로 점검
        // 방문 했을 때 => true & 다음 바퀴의 재귀
        // 방문 하지 않았을 때 => false

        // 이 때, 대부분 결과물을 배열에 담는 방법을 사용하는데
        // 나는 지금 얘들을 하나의 string으로 연결하는 게 필요하니 그걸로 만들어보자.
        // 그리고 걔들을 set에 담아서 중복제거해줄거야.

        arr = new String[]{"A", "B", "C", "D", "E"};
        N = arr.length;
        visited = new boolean[5];
        K = 3;
        set = new HashSet<>();

        StringBuilder sb = new StringBuilder();

        permutation(0, sb);

        set.forEach(e -> System.out.print(e + ", "));
        System.out.println();
        System.out.println(set.size());

    }
    static void permutation(int k, StringBuilder sb){
        if (k==K) {
            set.add(sb.toString());
//            sb.setLength(0);
            return;
        }

        for (int i=0; i<N; i++){
            if (visited[i]) continue;
            sb.append(arr[i]);
            visited[i] = true;
            permutation(k+1, sb);
            sb.setLength(sb.length()-1);
            visited[i] = false;

        }
    }
}