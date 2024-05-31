package no05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Ex009_18511_2_완전탐색 {

    public static void main(String[] args) throws IOException {
        // https://www.acmicpc.net/problem/18511

        // 각 자리수로 접근하면 경우의 수가 많아
        // 결국 N에서 -- 해가면서 접근할 수 밖에 없나...?!!!
        // 성공은 했는데 엄청 느림... ㅋㅋㅋㅋ
        // N--로 반복문을 만드는 게 아니라 K 집합 입장에서 반복문을 만들면 더 낫지 않을까?

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        HashSet<Character> set = new HashSet<>();
        for (int i=0; i<K; i++){
            set.add(st.nextToken().charAt(0));
        }

        for (int i=N; 0<i; i--){
            String str = Integer.toString(i);
            int j=0;
            while (j<str.length()){
                if (!set.contains(str.charAt(j))) break;
                j++;
            }
            if (j==str.length()) {
                System.out.println(i);
                break;
            }
        }
    }
}
