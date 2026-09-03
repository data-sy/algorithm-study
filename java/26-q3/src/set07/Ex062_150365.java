package src.set07;

import java.util.*;

public class Ex062_150365 {

    // 문제: 미로 탈출 명령어
    // https://school.programmers.co.kr/learn/courses/30/lessons/150365

    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        // TODO: 풀이 작성
        return "";
    }

    // ===== 아래는 채점용. 풀이만 위에서 수정하면 됩니다 =====

    public static void main(String[] args) {
        Ex062_150365 s = new Ex062_150365();

        check(1, s.solution(3, 4, 2, 3, 3, 1, 5), "dllrl");
        check(2, s.solution(2, 2, 1, 1, 2, 2, 2), "dr");
        check(3, s.solution(3, 3, 1, 2, 3, 3, 4), "impossible");
    }

    private static void check(int no, String actual, String expected) {
        System.out.printf("예 #%d  [%s]  기대값=%s  내결과=%s%n",
                no, Objects.equals(actual, expected) ? "PASS" : "FAIL", expected, actual);
    }
}
