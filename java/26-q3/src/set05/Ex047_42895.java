package src.set05;

import java.util.*;

public class Ex047_42895 {

    // 문제: N으로 표현
    // https://school.programmers.co.kr/learn/courses/30/lessons/42895
    // 키워드: DP·브루트포싱 - N을 i개 쓴 값들의 집합을 1개부터 8개까지 쌓아 올린다
    // 레벨: Lv.3 (동적계획법(Dynamic Programming))
    //
    // 제한사항
    // - N은 1 이상 9 이하
    // - number는 1 이상 32,000 이하
    // - 수식에는 괄호와 사칙연산만 가능하며 나누기 연산에서 나머지는 무시
    // - 최솟값이 8보다 크면 -1을 return

    public int solution(int N, int number) {
        // TODO: 풀이 작성
        return 0;
    }

    // ===== 아래는 채점용. 풀이만 위에서 수정하면 됩니다 =====

    public static void main(String[] args) {
        Ex047_42895 s = new Ex047_42895();

        check(1, s.solution(5, 12), 4);
        check(2, s.solution(2, 11), 3);
    }

    private static void check(int no, int actual, int expected) {
        System.out.printf("예 #%d  [%s]  기대값=%s  내결과=%s%n",
                no, actual == expected ? "PASS" : "FAIL", expected, actual);
    }
}
