package src.set02;

import java.util.*;

public class Ex014_12909 {

    // 문제: 올바른 괄호
    // https://school.programmers.co.kr/learn/courses/30/lessons/12909

    public boolean solution(String s) {
        // TODO: 풀이 작성
        return false;
    }

    // ===== 아래는 채점용. 풀이만 위에서 수정하면 됩니다 =====

    public static void main(String[] args) {
        Ex014_12909 s = new Ex014_12909();

        check(1, s.solution("()()"), true);
        check(2, s.solution("(())()"), true);
        check(3, s.solution(")()("), false);
        check(4, s.solution("(()("), false);
    }

    private static void check(int no, boolean actual, boolean expected) {
        System.out.printf("예 #%d  [%s]  기대값=%s  내결과=%s%n",
                no, actual == expected ? "PASS" : "FAIL", expected, actual);
    }
}
