package no05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Ex009_18511_큰수구성_1K중복순열재귀 {

    static long N;
    static int lenN;
    static int K;
    static int[] arr;
    static long max;

    public static void main(String[] args) throws IOException {
        // https://www.acmicpc.net/problem/18511

        // 1. K 입장에서 완전탐색
        // 2. N-- 완전탐색 => 성공했지만 느려
        // 3. 각 자리수 별로 treeSet의 floor 사용 => 실패. 나중에 재귀 더 알게 되면 다시 해보자!

        // K 입장에서 완전탐색 진행해보자
            // N의 길이만큼 K를 중복순열로 추출해서 해당 수가 N보다 큰지 비교!

        // (반복을 줄일 수 있는 방법으로)
        // N의 길이만큼 만들 수 있는 최소의 값과 N 비교
            // N보다 크면 N-1 길이만큼 last로 채우기
            // N보다 작으면 중복순열로 길이 N인 수를 만들어서 max를 갱신
        // 1000 3
        // 1 2 5
        // 1111은 N을 넘어가므로 555가 제일 가까운 큰 수

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        String str = st.nextToken();
        lenN = str.length();
        N = Long.parseLong(str);
        K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new int[K];
        for (int i=0; i<K; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr); // 오름차순

        // N과 같은 자리수로 만들 수 있는 최소의 수를 N과 비교
            // N보다 크면 N-1 길이만큼 arr[K-1]로 채우기
        str = Integer.toString(arr[0]).repeat(lenN);
        if (N<Long.parseLong(str)) max = Long.parseLong(Integer.toString(arr[K-1]).repeat(lenN-1));
        else { // N보다 작으면
            // 이 값을 max로 초기화 하고
            max = Long.parseLong(str);
            // K로 완전탐색 해서 N자리만큼 만들어서 max 갱신
            recur(0, sb);
        }
        System.out.println(max);

    }
    static void recur(int idx, StringBuilder sb){
        if (idx==lenN){
            long num = Long.parseLong(sb.toString());
            if (num<=N && max<num) max = num;
            return;
        }
        for (int i=0; i<K; i++) {
            sb.append(arr[i]);
            recur(idx+1, sb);
            sb.setLength(sb.length()-1);
        }
    }

}
