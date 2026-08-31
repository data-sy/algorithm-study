package src.Lv2;

import java.util.*;

public class Ex046_72411 {

    // 문제: 메뉴 리뉴얼
    // https://school.programmers.co.kr/learn/courses/30/lessons/72411
    // 키워드: 브루트포싱·조합·문자열 - 코스 길이별 조합을 세어 최다(2회 이상) 조합만 남긴다
    // 레벨: Lv.2 (2021 KAKAO BLIND RECRUITMENT)
    //
    // 제한사항
    // - orders 배열의 크기는 2 이상 20 이하
    // - orders의 각 원소는 크기가 2 이상 10 이하인 문자열
    //   (각 문자는 대문자 알파벳이며 중복되지 않음)
    // - course 배열의 크기는 1 이상 10 이하
    // - course의 각 원소는 2 이상 10 이하인 자연수이며 중복되지 않음
    // - 반환 배열은 사전 순으로 오름차순 정렬
    // - 같은 개수로 가장 많이 함께 주문된 메뉴 조합이 여러 개면 모두 반환

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
