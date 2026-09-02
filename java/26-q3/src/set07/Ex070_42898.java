package src.set07;

import java.util.*;

public class Ex070_42898 {

    // 문제: 등굣길
    // https://school.programmers.co.kr/learn/courses/30/lessons/42898
    // 키워드: DP - 오른쪽·아래로만 이동. dp[i][j] = 위 + 왼쪽, 물웅덩이는 0
    // 레벨: Lv.3 (동적계획법(Dynamic Programming))
    //
    // 제한사항
    // - 격자의 크기 m, n은 1 이상 100 이하인 자연수
    // - m과 n이 모두 1인 경우는 입력으로 주어지지 않음
    // - 물에 잠긴 지역은 0개 이상 10개 이하
    // - 집과 학교가 물에 잠긴 경우는 입력으로 주어지지 않음
    // - 경우의 수를 1,000,000,007로 나눈 나머지를 return

    public int solution(int m, int n, int[][] puddles) {
        // TODO: 풀이 작성
        return 0;
    }

    // ===== 아래는 채점용. 풀이만 위에서 수정하면 됩니다 =====

    public static void main(String[] args) {
        Ex070_42898 s = new Ex070_42898();

        check(1, s.solution(4, 3, new int[][]{{2, 2}}), 4);
    }

    private static void check(int no, int actual, int expected) {
        System.out.printf("예 #%d  [%s]  기대값=%s  내결과=%s%n",
                no, actual == expected ? "PASS" : "FAIL", expected, actual);
    }
}
