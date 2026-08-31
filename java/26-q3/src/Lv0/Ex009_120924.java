package src.Lv0;

import java.util.*;

public class Ex009_120924 {

    // 문제: 다음에 올 숫자
    // https://school.programmers.co.kr/learn/courses/30/lessons/120924
    // 키워드: 수학 - 등차수열 또는 등비수열의 마지막 원소 다음에 올 숫자
    // 레벨: Lv.0 (코딩테스트 입문)
    //
    // 제한사항
    // - 2 < common의 길이 < 1,000
    // - -1,000 < common의 원소 < 2,000
    // - common의 원소는 모두 정수
    // - 등차수열 혹은 등비수열이 아닌 경우는 없음
    // - 등비수열인 경우 공비는 0이 아닌 정수

    public int solution(int[] common) {
        // TODO: 풀이 작성
        return 0;
    }

    // ===== 아래는 채점용. 풀이만 위에서 수정하면 됩니다 =====

    public static void main(String[] args) {
        Ex009_120924 s = new Ex009_120924();

        check(1, s.solution(new int[]{1, 2, 3, 4}), 5);
        check(2, s.solution(new int[]{2, 4, 8}), 16);
    }

    private static void check(int no, int actual, int expected) {
        System.out.printf("예 #%d  [%s]  기대값=%s  내결과=%s%n",
                no, actual == expected ? "PASS" : "FAIL", expected, actual);
    }
}
