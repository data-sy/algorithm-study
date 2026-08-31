package src.Lv1;

import java.util.*;

public class Ex037_12977 {

    // 문제: 소수 만들기
    // https://school.programmers.co.kr/learn/courses/30/lessons/12977
    // 키워드: 브루트포싱·조합·수학 - 서로 다른 3개를 고른 합이 소수인 경우의 수
    // 레벨: Lv.1 (Summer/Winter Coding(~2018))
    //
    // 제한사항
    // - nums에 들어있는 숫자의 개수는 3개 이상 50개 이하
    // - nums의 각 원소는 1 이상 1,000 이하의 자연수이며, 중복된 숫자가 들어있지 않음

    public int solution(int[] nums) {
        // TODO: 풀이 작성
        return 0;
    }

    // ===== 아래는 채점용. 풀이만 위에서 수정하면 됩니다 =====

    public static void main(String[] args) {
        Ex037_12977 s = new Ex037_12977();

        check(1, s.solution(new int[]{1, 2, 3, 4}), 1);
        check(2, s.solution(new int[]{1, 2, 7, 6, 4}), 4);
    }

    private static void check(int no, int actual, int expected) {
        System.out.printf("예 #%d  [%s]  기대값=%s  내결과=%s%n",
                no, actual == expected ? "PASS" : "FAIL", expected, actual);
    }
}
