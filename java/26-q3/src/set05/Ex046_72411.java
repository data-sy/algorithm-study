package src.set05;

import java.util.*;

public class Ex046_72411 {

    // 문제: 메뉴 리뉴얼
    // https://school.programmers.co.kr/learn/courses/30/lessons/72411

    public String[] solution(String[] orders, int[] course) {
        // TODO: 풀이 작성
        return new String[0];
    }

    // ===== 아래는 채점용. 풀이만 위에서 수정하면 됩니다 =====

    public static void main(String[] args) {
        Ex046_72411 s = new Ex046_72411();

        check(1, s.solution(
                new String[]{"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"},
                new int[]{2, 3, 4}),
                new String[]{"AC", "ACDE", "BCFG", "CDE"});
        check(2, s.solution(
                new String[]{"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"},
                new int[]{2, 3, 5}),
                new String[]{"ACD", "AD", "ADE", "CD", "XYZ"});
    }

    private static void check(int no, String[] actual, String[] expected) {
        System.out.printf("예 #%d  [%s]  기대값=%s  내결과=%s%n",
                no, Arrays.equals(actual, expected) ? "PASS" : "FAIL",
                Arrays.toString(expected), Arrays.toString(actual));
    }
}
