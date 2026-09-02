package src.set03;

import java.util.*;

public class Ex024_42885 {

    // 문제: 구명보트
    // https://school.programmers.co.kr/learn/courses/30/lessons/42885
    // 키워드: 투 포인터·그리디·정렬 - 정렬 후 가장 가벼운 사람과 가장 무거운 사람을 짝지어 본다
    // 레벨: Lv.2 (탐욕법)
    //
    // 제한사항
    // - 무인도에 갇힌 사람은 1명 이상 50,000명 이하
    // - 각 사람의 몸무게는 40kg 이상 240kg 이하
    // - 구명보트의 무게 제한은 40kg 이상 240kg 이하
    // - 구명보트의 무게 제한은 항상 사람들의 몸무게 중 최댓값보다 크므로 구출할 수 없는 사람은 없음

    public int solution(int[] people, int limit) {
        // TODO: 풀이 작성
        return 0;
    }

    // ===== 아래는 채점용. 풀이만 위에서 수정하면 됩니다 =====

    public static void main(String[] args) {
        Ex024_42885 s = new Ex024_42885();

        check(1, s.solution(new int[]{70, 50, 80, 50}, 100), 3);
        check(2, s.solution(new int[]{70, 80, 50}, 100), 3);
    }

    private static void check(int no, int actual, int expected) {
        System.out.printf("예 #%d  [%s]  기대값=%s  내결과=%s%n",
                no, actual == expected ? "PASS" : "FAIL", expected, actual);
    }
}
