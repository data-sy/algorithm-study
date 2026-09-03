package src.set07;

import java.util.*;

public class Ex069_87694 {

    // 문제: 아이템 줍기
    // https://school.programmers.co.kr/learn/courses/30/lessons/87694

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        // TODO: 풀이 작성
        return 0;
    }

    // ===== 아래는 채점용. 풀이만 위에서 수정하면 됩니다 =====

    public static void main(String[] args) {
        Ex069_87694 s = new Ex069_87694();

        check(1, s.solution(new int[][]{{1, 1, 7, 4}, {3, 2, 5, 5}, {4, 3, 6, 9}, {2, 6, 8, 8}},
                1, 3, 7, 8), 17);
        check(2, s.solution(new int[][]{{1, 1, 8, 4}, {2, 2, 4, 9}, {3, 6, 9, 8}, {6, 3, 7, 7}},
                9, 7, 6, 1), 11);
        check(3, s.solution(new int[][]{{1, 1, 5, 7}}, 1, 1, 4, 7), 9);
        check(4, s.solution(new int[][]{{2, 1, 7, 5}, {6, 4, 10, 10}}, 3, 1, 7, 10), 15);
        check(5, s.solution(new int[][]{{2, 2, 5, 5}, {1, 3, 6, 4}, {3, 1, 4, 6}}, 1, 4, 6, 3), 10);
    }

    private static void check(int no, int actual, int expected) {
        System.out.printf("예 #%d  [%s]  기대값=%s  내결과=%s%n",
                no, actual == expected ? "PASS" : "FAIL", expected, actual);
    }
}
