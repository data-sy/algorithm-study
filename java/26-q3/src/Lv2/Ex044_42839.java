package src.Lv2;

import java.util.*;

public class Ex044_42839 {

    // 문제: 소수 찾기
    // https://school.programmers.co.kr/learn/courses/30/lessons/42839
    // 키워드: 브루트포싱·백트래킹·수학 - 조각으로 만들 수 있는 모든 순열 수 중 소수의 개수
    // 레벨: Lv.2 (완전탐색)
    //
    // 제한사항
    // - numbers는 길이 1 이상 7 이하인 문자열
    // - numbers는 0~9까지 숫자만으로 이루어져 있음
    // - "013"은 0, 1, 3 숫자가 적힌 종이 조각이 흩어져 있다는 의미

    public int solution(String numbers) {
        // TODO: 풀이 작성
        return 0;
    }

    // ===== 아래는 채점용. 풀이만 위에서 수정하면 됩니다 =====

    public static void main(String[] args) {
        Ex044_42839 s = new Ex044_42839();

        check(1, s.solution("17"), 3);
        check(2, s.solution("011"), 2);
    }

    private static void check(int no, int actual, int expected) {
        System.out.printf("예 #%d  [%s]  기대값=%s  내결과=%s%n",
                no, actual == expected ? "PASS" : "FAIL", expected, actual);
    }
}
