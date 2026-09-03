package src.set02;

import java.util.*;

public class Ex012_42577 {

    // 문제: 전화번호 목록
    // https://school.programmers.co.kr/learn/courses/30/lessons/42577

    public boolean solution(String[] phone_book) {
        // TODO: 풀이 작성
        return false;
    }

    // ===== 아래는 채점용. 풀이만 위에서 수정하면 됩니다 =====

    public static void main(String[] args) {
        Ex012_42577 s = new Ex012_42577();

        check(1, s.solution(new String[]{"119", "97674223", "1195524421"}), false);
        check(2, s.solution(new String[]{"123", "456", "789"}), true);
        check(3, s.solution(new String[]{"12", "123", "1235", "567", "88"}), false);
    }

    private static void check(int no, boolean actual, boolean expected) {
        System.out.printf("예 #%d  [%s]  기대값=%s  내결과=%s%n",
                no, actual == expected ? "PASS" : "FAIL", expected, actual);
    }
}
