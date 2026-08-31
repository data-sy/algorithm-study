package src.Lv2;

import java.util.*;

public class Ex036_68936 {

    // 문제: 쿼드압축 후 개수 세기
    // https://school.programmers.co.kr/learn/courses/30/lessons/68936
    // 키워드: 재귀·분할 정복 - 사분면이 전부 같은 값이면 하나로 합치고, 아니면 4등분해 재귀
    // 레벨: Lv.2 (월간 코드 챌린지 시즌1)
    //
    // 제한사항
    // - arr의 행의 개수는 1 이상 1024 이하이며, 2의 거듭 제곱수 형태
    //   (1, 2, 4, 8, ..., 1024)
    // - arr의 각 행의 길이는 arr의 행의 개수와 같음 (정사각형 배열)
    // - arr의 원소는 0 또는 1
    // - 반환값은 [0의 개수, 1의 개수]

    public int[] solution(int[][] arr) {
        // TODO: 풀이 작성
        return new int[0];
    }

    // ===== 아래는 채점용. 풀이만 위에서 수정하면 됩니다 =====

    public static void main(String[] args) {
        Ex036_68936 s = new Ex036_68936();

        check(1, s.solution(new int[][]{
                {1, 1, 0, 0},
                {1, 0, 0, 0},
                {1, 0, 0, 1},
                {1, 1, 1, 1}}), new int[]{4, 9});
        check(2, s.solution(new int[][]{
                {1, 1, 1, 1, 1, 1, 1, 1},
                {0, 1, 1, 1, 1, 1, 1, 1},
                {0, 0, 0, 0, 1, 1, 1, 1},
                {0, 1, 0, 0, 1, 1, 1, 1},
                {0, 0, 0, 0, 0, 0, 1, 1},
                {0, 0, 0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 1, 0, 0, 1},
                {0, 0, 0, 0, 1, 1, 1, 1}}), new int[]{10, 15});
    }

    private static void check(int no, int[] actual, int[] expected) {
        System.out.printf("예 #%d  [%s]  기대값=%s  내결과=%s%n",
                no, Arrays.equals(actual, expected) ? "PASS" : "FAIL",
                Arrays.toString(expected), Arrays.toString(actual));
    }
}
