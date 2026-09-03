package src.set07;

import java.util.*;

public class Ex061_169199 {

    // 문제: 리코쳇 로봇
    // https://school.programmers.co.kr/learn/courses/30/lessons/169199

    public int solution(String[] board) {
        // TODO: 풀이 작성
        return 0;
    }

    // ===== 아래는 채점용. 풀이만 위에서 수정하면 됩니다 =====

    public static void main(String[] args) {
        Ex061_169199 s = new Ex061_169199();

        check(1, s.solution(new String[]{"...D..R", ".D.G...", "....D.D", "D....D.", "..D...."}), 7);
        check(2, s.solution(new String[]{".D.R", "....", ".G..", "...D"}), -1);
    }

    private static void check(int no, int actual, int expected) {
        System.out.printf("예 #%d  [%s]  기대값=%s  내결과=%s%n",
                no, actual == expected ? "PASS" : "FAIL", expected, actual);
    }
}
