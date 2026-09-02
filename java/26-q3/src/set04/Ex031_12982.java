package src.set04;

import java.util.*;

public class Ex031_12982 {

    // 문제: 예산
    // https://school.programmers.co.kr/learn/courses/30/lessons/12982
    // 키워드: 그리디·정렬 - 신청 금액이 적은 부서부터 예산이 닿는 데까지 지원
    // 레벨: Lv.1 (summer/winter coding(~2018))
    //
    // 제한사항
    // - d는 부서별로 신청한 금액이 들어있는 배열이며, 길이(전체 부서의 개수)는 1 이상 100 이하
    // - d의 각 원소는 부서별로 신청한 금액을 나타내며, 각 금액은 1 이상 100,000 이하의 자연수
    // - budget은 예산을 나타내며, 1 이상 10,000,000 이하의 자연수

    public int solution(int[] d, int budget) {
        // TODO: 풀이 작성
        return 0;
    }

    // ===== 아래는 채점용. 풀이만 위에서 수정하면 됩니다 =====

    public static void main(String[] args) {
        Ex031_12982 s = new Ex031_12982();

        check(1, s.solution(new int[]{1, 3, 2, 5, 4}, 9), 3);
        check(2, s.solution(new int[]{2, 2, 3, 3}, 10), 4);
    }

    private static void check(int no, int actual, int expected) {
        System.out.printf("예 #%d  [%s]  기대값=%s  내결과=%s%n",
                no, actual == expected ? "PASS" : "FAIL", expected, actual);
    }
}
