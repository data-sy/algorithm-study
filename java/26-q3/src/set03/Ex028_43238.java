package src.set03;

import java.util.*;

public class Ex028_43238 {

    // 문제: 입국심사
    // https://school.programmers.co.kr/learn/courses/30/lessons/43238
    // 키워드: 이분 탐색 - "T분 안에 n명을 처리할 수 있는가"를 판정하며 답 구간을 좁힌다 (long 주의)
    // 레벨: Lv.3 (이분탐색)
    //
    // 제한사항
    // - 입국심사를 위해 대기하는 사람은 1명 이상 1,000,000,000명 이하
    // - 각 심사관이 한 명을 심사하는 데 걸리는 시간은 1분 이상 1,000,000,000분 이하
    // - 심사관은 1명 이상 100,000명 이하

    public long solution(int n, int[] times) {
        // TODO: 풀이 작성
        return 0L;
    }

    // ===== 아래는 채점용. 풀이만 위에서 수정하면 됩니다 =====

    public static void main(String[] args) {
        Ex028_43238 s = new Ex028_43238();

        check(1, s.solution(6, new int[]{7, 10}), 28L);
    }

    private static void check(int no, long actual, long expected) {
        System.out.printf("예 #%d  [%s]  기대값=%s  내결과=%s%n",
                no, actual == expected ? "PASS" : "FAIL", expected, actual);
    }
}
