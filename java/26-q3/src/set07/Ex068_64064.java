package src.set07;

import java.util.*;

public class Ex068_64064 {

    // 문제: 불량 사용자
    // https://school.programmers.co.kr/learn/courses/30/lessons/64064
    // 키워드: 백트래킹·브루트포싱·문자열 - 제재 아이디 목록에 매칭되는 응모자 집합의 경우의 수
    // 레벨: Lv.3 (2019 KAKAO BLIND RECRUITMENT)
    //
    // 제한사항
    // - user_id 배열의 크기는 1 이상 8 이하
    // - user_id 배열 각 원소들의 값은 길이가 1 이상 8 이하인 문자열
    // - 응모한 사용자 아이디들은 알파벳 소문자와 숫자로만 구성
    // - 응모한 사용자 아이디들은 서로 중복되지 않음
    // - banned_id 배열의 크기는 1 이상 user_id 배열의 크기 이하
    // - banned_id 배열 각 원소들의 값은 길이가 1 이상 8 이하인 문자열
    // - 불량 사용자 아이디는 알파벳 소문자와 숫자, 가리기 위한 문자 '*'로만 구성
    // - 불량 사용자 아이디는 '*'로 하나 이상 가려져 있음
    // - 불량 사용자 아이디 목록에는 같은 아이디가 중복해서 들어있을 수 있음

    public int solution(String[] user_id, String[] banned_id) {
        // TODO: 풀이 작성
        return 0;
    }

    // ===== 아래는 채점용. 풀이만 위에서 수정하면 됩니다 =====

    public static void main(String[] args) {
        Ex068_64064 s = new Ex068_64064();

        String[] users = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        check(1, s.solution(users, new String[]{"fr*d*", "abc1**"}), 2);
        check(2, s.solution(users, new String[]{"*rodo", "*rodo", "******"}), 2);
        check(3, s.solution(users, new String[]{"fr*d*", "*rodo", "******", "******"}), 3);
    }

    private static void check(int no, int actual, int expected) {
        System.out.printf("예 #%d  [%s]  기대값=%s  내결과=%s%n",
                no, actual == expected ? "PASS" : "FAIL", expected, actual);
    }
}
