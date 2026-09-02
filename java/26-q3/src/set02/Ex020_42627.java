package src.set02;

import java.util.*;

public class Ex020_42627 {

    // 문제: 디스크 컨트롤러
    // https://school.programmers.co.kr/learn/courses/30/lessons/42627
    // 키워드: 우선순위 큐·정렬·시뮬레이션 - 도착한 작업 중 소요 시간이 짧은 것부터 (SJF)
    // 레벨: Lv.3 (힙)
    //
    // 제한사항
    // - jobs의 길이는 1 이상 500 이하
    // - jobs의 각 행은 [작업이 요청되는 시점, 작업의 소요시간]
    // - 각 작업에 대해 작업이 요청되는 시간은 0 이상 1,000 이하
    // - 각 작업에 대해 작업의 소요시간은 1 이상 1,000 이하
    // - 하드디스크가 작업을 수행하고 있지 않을 때에는 먼저 요청이 들어온 작업부터 처리
    // - 반환값은 모든 작업의 반환 시간 평균의 정수 부분

    public int solution(int[][] jobs) {
        // TODO: 풀이 작성
        return 0;
    }

    // ===== 아래는 채점용. 풀이만 위에서 수정하면 됩니다 =====

    public static void main(String[] args) {
        Ex020_42627 s = new Ex020_42627();

        check(1, s.solution(new int[][]{{0, 3}, {1, 9}, {3, 5}}), 8);
    }

    private static void check(int no, int actual, int expected) {
        System.out.printf("예 #%d  [%s]  기대값=%s  내결과=%s%n",
                no, actual == expected ? "PASS" : "FAIL", expected, actual);
    }
}
