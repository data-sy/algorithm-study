package src.Lv2;

import java.util.*;

public class Ex043_87946 {

    // 문제: 피로도
    // https://school.programmers.co.kr/learn/courses/30/lessons/87946
    // 키워드: 브루트포싱·백트래킹 - 던전 최대 8개이므로 모든 방문 순열을 시도한다
    // 레벨: Lv.2 (Summer/Winter Coding(~2018))
    //
    // 제한사항
    // - k는 1 이상 5,000 이하인 자연수
    // - dungeons의 세로(행) 길이(즉, 던전의 개수)는 1 이상 8 이하
    // - dungeons의 가로(열) 길이는 2
    // - dungeons의 각 행은 [최소 필요 피로도, 소모 피로도]
    // - 최소 필요 피로도는 항상 소모 피로도보다 크거나 같음
    // - 최소 필요 피로도와 소모 피로도는 1 이상 1,000 이하인 자연수

    public int solution(int k, int[][] dungeons) {
        // TODO: 풀이 작성
        return 0;
    }

    // ===== 아래는 채점용. 풀이만 위에서 수정하면 됩니다 =====

    public static void main(String[] args) {
        Ex043_87946 s = new Ex043_87946();

        check(1, s.solution(80, new int[][]{{80, 20}, {50, 40}, {30, 10}}), 3);
    }

    private static void check(int no, int actual, int expected) {
        System.out.printf("예 #%d  [%s]  기대값=%s  내결과=%s%n",
                no, actual == expected ? "PASS" : "FAIL", expected, actual);
    }
}
