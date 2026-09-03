package src.set03;

import java.util.*;

public class Ex027_67258 {

    // 문제: 보석 쇼핑
    // https://school.programmers.co.kr/learn/courses/30/lessons/67258

    public int[] solution(String[] gems) {
        // TODO: 풀이 작성
        return new int[0];
    }

    // ===== 아래는 채점용. 풀이만 위에서 수정하면 됩니다 =====

    public static void main(String[] args) {
        Ex027_67258 s = new Ex027_67258();

        check(1, s.solution(new String[]{"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"}),
                new int[]{3, 7});
        check(2, s.solution(new String[]{"AA", "AB", "AC", "AA", "AC"}), new int[]{1, 3});
        check(3, s.solution(new String[]{"XYZ", "XYZ", "XYZ"}), new int[]{1, 1});
        check(4, s.solution(new String[]{"ZZZ", "YYY", "NNNN", "YYY", "BBB"}), new int[]{1, 5});
    }

    private static void check(int no, int[] actual, int[] expected) {
        System.out.printf("예 #%d  [%s]  기대값=%s  내결과=%s%n",
                no, Arrays.equals(actual, expected) ? "PASS" : "FAIL",
                Arrays.toString(expected), Arrays.toString(actual));
    }
}
