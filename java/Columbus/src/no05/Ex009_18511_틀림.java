package no05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Ex009_18511_틀림 {

    public static void main(String[] args) throws IOException {
        // https://www.acmicpc.net/problem/18511

        // 1. K 입장에서 완전탐색
        // 2. N-- 완전탐색 => 성공했지만 느려
        // 3. 각 자리수 별로 treeSet의 floor 사용 => 실패. 나중에 재귀 더 알게 되면 다시 해보자!

        // N의 길이만큼 만들 수 있는 최소의 값과 N 비교
            // N보다 크면 N-1 길이만큼 last로 채우기
            // N보다 작으면 floor 찾아가며 채우기

        // 예)
        // 22215 3
        // 2 5 7
        // 22222로는 안 되니까 7777이 제일 가까운 큰 수야
        // 22235 3
        // 2 5 7
        // 22222보다 크니까 다들 최소 floor는 보장이 돼
        // 22227 floor가 작아지는 순간 멈추고 나머지는 last로 채우기

        // nullPointer 에러. floor가 존재하지 않는 경우 나올 수 있다는거지?!
        // 25217 3
        // 2 5 7
        // 이러면 1에서 NullPointer

        // 결국 floor가 null이면 위로 올라가서 그 보다 작은 floor를 다시 선택하는 과정 필요 => 재귀?!

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        String N = st.nextToken();
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        TreeSet<Integer> set = new TreeSet<>();
        for (int i=0; i<K; i++){
            set.add(Integer.parseInt(st.nextToken()));
        }

        // N과 같은 자리수로 만들 수 있는 최소의 수를 N과 비교
        if (Long.parseLong(N)<Long.parseLong(Integer.toString(set.first()).repeat(N.length()))) { // N보다 크면 N-1 길이만큼 last로 채우기
            sb.append(Integer.toString(set.last()).repeat(N.length()-1));
        } else { // N보다 작으면 floor 찾아가며 채우기
            for (int i=0; i<N.length(); i++){
                int num = Character.getNumericValue(N.charAt(i));
                sb.append(set.floor(num));
                if (set.floor(num)<num) break;
            }
            while(sb.length()<N.length()){
                sb.append(set.last());
            }
        }
        System.out.println(sb);

    }

}
