package src.set05;

import java.util.*;

public class Ex042_84512 {

    // 문제: 모음사전
    // https://school.programmers.co.kr/learn/courses/30/lessons/84512
    // 키워드: 브루트포싱·DFS·백트래킹 - AEIOU로 만든 사전 순 단어에서 word가 몇 번째인지
    // 레벨: Lv.2 (2021 카카오 채용연계형 인턴십)
    //
    // 제한사항
    // - word의 길이는 1 이상 5 이하
    // - word는 알파벳 대문자 'A', 'E', 'I', 'O', 'U'로만 이루어져 있음

    public int solution(String word) {
        // TODO: 풀이 작성
        return 0;
    }

    // ===== 아래는 채점용. 풀이만 위에서 수정하면 됩니다 =====

    public static void main(String[] args) {
        Ex042_84512 s = new Ex042_84512();

        check(1, s.solution("AAAAE"), 6);
        check(2, s.solution("AAAE"), 10);
        check(3, s.solution("I"), 1563);
        check(4, s.solution("EIO"), 1189);
    }

    private static void check(int no, int actual, int expected) {
        System.out.printf("예 #%d  [%s]  기대값=%s  내결과=%s%n",
                no, actual == expected ? "PASS" : "FAIL", expected, actual);
    }
}
