package src.set05;

import java.util.*;

public class Ex049_43162 {

    // 문제: 네트워크
    // https://school.programmers.co.kr/learn/courses/30/lessons/43162
    // 키워드: DFS·BFS·그래프 이론 - 연결 요소(connected component)의 개수
    // 레벨: Lv.3 (깊이/너비 우선 탐색(DFS/BFS))
    //
    // 제한사항
    // - 컴퓨터의 개수 n은 1 이상 200 이하인 자연수
    // - 각 컴퓨터는 0부터 n-1인 정수로 표현
    // - i번 컴퓨터와 j번 컴퓨터가 연결되어 있으면 computers[i][j]를 1로 표현
    // - computers[i][i]는 항상 1

    public int solution(int n, int[][] computers) {
        // TODO: 풀이 작성
        return 0;
    }

    // ===== 아래는 채점용. 풀이만 위에서 수정하면 됩니다 =====

    public static void main(String[] args) {
        Ex049_43162 s = new Ex049_43162();

        check(1, s.solution(3, new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}), 2);
        check(2, s.solution(3, new int[][]{{1, 1, 0}, {1, 1, 1}, {0, 1, 1}}), 1);
    }

    private static void check(int no, int actual, int expected) {
        System.out.printf("예 #%d  [%s]  기대값=%s  내결과=%s%n",
                no, actual == expected ? "PASS" : "FAIL", expected, actual);
    }
}
