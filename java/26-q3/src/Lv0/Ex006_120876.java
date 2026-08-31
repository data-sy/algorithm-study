package src.Lv0;

import java.util.*;

public class Ex006_120876 {

    // 문제: 겹치는 선분의 길이
    // https://school.programmers.co.kr/learn/courses/30/lessons/120876
    // 키워드: 구간 - 세 선분 중 두 개 이상이 겹치는 구간의 길이 (단위 구간 카운팅)
    // 레벨: Lv.0 (코딩테스트 입문)
    //
    // 제한사항
    // - lines의 길이 = 3, lines의 원소의 길이 = 2
    // - 모든 선분은 길이가 1 이상
    // - lines의 원소는 [a, b] 형태이며 -100 <= a < b <= 100

    public int solution(int[][] lines) {
        int answer = 0;
        int[] line = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<lines.length; i++) {
            line = lines[i];
            for (int j=line[0]; j<line[1]; j++) {
                map.put(j, map.getOrDefault(j, 0)+1);
            }
        }
        for (Integer integer : map.values()) {
            if (integer>1) answer++;
        }
        return answer;
    }

    // ===== 아래는 채점용. 풀이만 위에서 수정하면 됩니다 =====

    public static void main(String[] args) {
        Ex006_120876 s = new Ex006_120876();

        check(1, s.solution(new int[][]{{0, 1}, {2, 5}, {3, 9}}), 2);
        check(2, s.solution(new int[][]{{-1, 1}, {1, 3}, {3, 9}}), 0);
        check(3, s.solution(new int[][]{{0, 5}, {3, 9}, {1, 10}}), 8);
    }

    private static void check(int no, int actual, int expected) {
        System.out.printf("예 #%d  [%s]  기대값=%d  내결과=%d%n",
                no, actual == expected ? "PASS" : "FAIL", expected, actual);
    }
}
