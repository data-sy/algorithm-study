package no05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Ex000_부분집합_재귀 {

    public static void main(String[] args) throws IOException {
        // https://www.acmicpc.net/problem/18511

        // 재귀를 이용한 부분집합 추출 : https://codevang.tistory.com/291

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        String N = st.nextToken();
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[K];
        for (int i=0; i<K; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        boolean[] visited = new boolean[K];

        powerset(arr, visited, 0, K);

    }
    /**
     * 모든 부분집합 구하기
     *
     * @param arr   : 원본 배열
     * @param state : "있을 경우와 없을 경우" 상태값 체크
     * @param i : 현재 기준이 되는 배열 인덱스
     * @param end   : 배열의 사이즈
     */
    public static void powerset(int[] arr, boolean[] state, int i, int end) {
        // 탈출문
        if (i >= end) {
            // 현재 true로 체크되어 있는 인덱스의 값만 출력
            for (int w = 0; w < end; w++) {
                if (state[w]) System.out.print(arr[w] + " ");
            }
            System.out.println();
            return;
        }
        // "내가 없을 경우"를 체크한 뒤 다른 부분집합을 구하는 재귀함수 호출 (다음 인덱스로 기준 이동)
        state[i] = false;
        powerset(arr, state, i + 1, end);

        // "내가 있을 경우"를 체크한 뒤 다른 부분집합을 구하는 재귀함수 호출 (다음 인덱스로 기준 이동)
        state[i] = true;
        powerset(arr, state, i + 1, end);
    }
}
