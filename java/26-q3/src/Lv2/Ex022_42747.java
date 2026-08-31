package src.Lv2;

import java.util.*;

public class Ex022_42747 {

    // 문제: H-Index
    // https://school.programmers.co.kr/learn/courses/30/lessons/42747
    // 키워드: 정렬 - h번 이상 인용된 논문이 h편 이상인 h의 최댓값
    // 레벨: Lv.2 (정렬)
    //
    // 제한사항
    // - 과학자가 발표한 논문의 수는 1편 이상 1,000편 이하
    // - 논문별 인용 횟수는 0회 이상 10,000회 이하

    public int solution(int[] citations) {
        // TODO: 풀이 작성
        return 0;
    }

    // ===== 아래는 채점용. 풀이만 위에서 수정하면 됩니다 =====

    public static void main(String[] args) {
        Ex022_42747 s = new Ex022_42747();

        check(1, s.solution(new int[]{3, 0, 6, 1, 5}), 3);
    }

    private static void check(int no, int actual, int expected) {
        System.out.printf("예 #%d  [%s]  기대값=%s  내결과=%s%n",
                no, actual == expected ? "PASS" : "FAIL", expected, actual);
    }
}
