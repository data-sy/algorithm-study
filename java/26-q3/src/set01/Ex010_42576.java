package src.set01;

import java.util.*;

public class Ex010_42576 {

    // 문제: 완주하지 못한 선수
    // https://school.programmers.co.kr/learn/courses/30/lessons/42576
    // 키워드: 해시 - 참가자 명단에서 완주자 명단을 빼고 남는 한 명 (동명이인 주의)
    // 레벨: Lv.1 (해시)
    //
    // 제한사항
    // - 마라톤 경기에 참여한 선수의 수는 1명 이상 100,000명 이하
    // - completion의 길이는 participant의 길이보다 1 작음
    // - 참가자의 이름은 1개 이상 20개 이하의 알파벳 소문자로 이루어짐
    // - 참가자 중에는 동명이인이 있을 수 있음

    public String solution(String[] participant, String[] completion) {
        // TODO: 풀이 작성
        return "";
    }

    // ===== 아래는 채점용. 풀이만 위에서 수정하면 됩니다 =====

    public static void main(String[] args) {
        Ex010_42576 s = new Ex010_42576();

        check(1, s.solution(
                new String[]{"leo", "kiki", "eden"},
                new String[]{"eden", "kiki"}), "leo");
        check(2, s.solution(
                new String[]{"marina", "josipa", "nikola", "vinko", "filipa"},
                new String[]{"josipa", "filipa", "marina", "nikola"}), "vinko");
        check(3, s.solution(
                new String[]{"mislav", "stanko", "mislav", "ana"},
                new String[]{"stanko", "ana", "mislav"}), "mislav");
    }

    private static void check(int no, String actual, String expected) {
        System.out.printf("예 #%d  [%s]  기대값=%s  내결과=%s%n",
                no, Objects.equals(actual, expected) ? "PASS" : "FAIL", expected, actual);
    }
}
