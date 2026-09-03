package src.set06;

import java.util.*;

public class Ex053_159993 {

    // 문제: 미로 탈출
    // https://school.programmers.co.kr/learn/courses/30/lessons/159993

    public int solution(String[] maps) {
        // TODO: 풀이 작성
        return 0;
    }

    // ===== 아래는 채점용. 풀이만 위에서 수정하면 됩니다 =====

    public static void main(String[] args) {
        Ex053_159993 s = new Ex053_159993();

        check(1, s.solution(new String[]{"SOOOL", "XXXXO", "OOOOO", "OXXXX", "OOOOE"}), 16);
        check(2, s.solution(new String[]{"LOOXS", "OOOOX", "OOOOO", "OOOOO", "EOOOO"}), -1);
    }

    private static void check(int no, int actual, int expected) {
        System.out.printf("예 #%d  [%s]  기대값=%s  내결과=%s%n",
                no, actual == expected ? "PASS" : "FAIL", expected, actual);
    }
}
