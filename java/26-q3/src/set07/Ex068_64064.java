package src.set07;

import java.util.*;

public class Ex068_64064 {

    // 문제: 불량 사용자
    // https://school.programmers.co.kr/learn/courses/30/lessons/64064

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
