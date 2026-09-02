package src.set06;

import java.util.*;

public class Ex056_12978 {

    // 문제: 배달
    // https://school.programmers.co.kr/learn/courses/30/lessons/12978
    // 키워드: 다익스트라·최단 거리 - 1번 마을 기준 최단거리가 K 이하인 마을 수 (중복 간선 주의)
    // 레벨: Lv.2 (Summer/Winter Coding(~2018))
    //
    // 제한사항
    // - 마을의 개수 N은 1 이상 50 이하의 자연수
    // - road의 길이(도로 정보의 개수)는 1 이상 2,000 이하
    // - road의 각 원소는 [a, b, c] 형태로 a번 마을과 b번 마을을 c시간에 오갈 수 있음
    // - a와 b는 1 이상 N 이하의 자연수이며 서로 다름
    // - c는 1 이상 10,000 이하의 자연수
    // - 두 마을 간에 도로가 두 개 이상 있을 수 있음
    // - K는 1 이상 500,000 이하의 자연수
    // - 임의의 두 마을은 항상 이동 가능한 경로가 존재

    public int solution(int N, int[][] road, int K) {
        // TODO: 풀이 작성
        return 0;
    }

    // ===== 아래는 채점용. 풀이만 위에서 수정하면 됩니다 =====

    public static void main(String[] args) {
        Ex056_12978 s = new Ex056_12978();

        check(1, s.solution(5, new int[][]{
                {1, 2, 1}, {2, 3, 3}, {5, 2, 2}, {1, 4, 2}, {5, 3, 1}, {5, 4, 2}}, 3), 4);
        check(2, s.solution(6, new int[][]{
                {1, 2, 1}, {1, 3, 2}, {2, 3, 2}, {3, 4, 3}, {3, 5, 2}, {3, 5, 3}, {5, 6, 1}}, 4), 4);
    }

    private static void check(int no, int actual, int expected) {
        System.out.printf("예 #%d  [%s]  기대값=%s  내결과=%s%n",
                no, actual == expected ? "PASS" : "FAIL", expected, actual);
    }
}
