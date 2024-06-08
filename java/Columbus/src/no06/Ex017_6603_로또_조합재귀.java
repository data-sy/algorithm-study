package no06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Ex017_6603_로또_조합재귀 {

    static int k;
    static String[] arr;
    static StringBuilder sb;
    static LinkedList<String> list;

    public static void main(String[] args) throws IOException {
        // https://www.acmicpc.net/problem/6603

        // k개 중 6개 선택 => 조합
            // 이 때 모든 조합의 경우를 각각 출력
            // 입력값이 오름차순으로 주어지므로 다른 조작 없이 그대로 진행

        // 재귀를 멈추는 조건이 6개를 고르는 것이므로 갯수 확실히 세려면 sb로는 부족 => 리스트에 담자

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        list = new LinkedList<>();
        sb = new StringBuilder();

        StringTokenizer st;

        while (true){
            st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            if (k==0) break;
            // arr 초기화
            arr = new String[k];
            for (int i=0; i<k; i++) {
                arr[i] = st.nextToken();
            }
            // list 초기화
            list.clear();
            recur(0);
            // 끝나면 엔터 넣기
            sb.append('\n');
        }
        System.out.println(sb);

    }
    static void recur(int i) {
        if (list.size()==6) {
            list.forEach(e->sb.append(e).append(' '));
            sb.append('\n');
            return;
        }
        if (i==k) return;

        // 포함할 때
        list.add(arr[i]);
        recur(i+1);
        // 포함하지 않을 때
        list.removeLast();
        recur(i+1);
    }

}
