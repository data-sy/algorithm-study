package src.Lv3;

import java.util.*;

public class Ex034_42884 {

    // 문제: 단속카메라
    // https://school.programmers.co.kr/learn/courses/30/lessons/42884
    // 키워드: 그리디·정렬 - 진출 지점 기준 정렬 후, 겹치지 않을 때만 카메라를 새로 놓는다
    // 레벨: Lv.3 (탐욕법)
    //
    // 제한사항
    // - 차량의 대수는 1대 이상 10,000대 이하
    // - routes에는 차량의 이동 경로가 포함되어 있으며 routes[i][0]에는 i번째 차량이
    //   고속도로에 진입한 지점, routes[i][1]에는 i번째 차량이 고속도로에서 나간 지점이 적혀 있음
    // - 차량의 진입/진출 지점에 카메라가 설치되어 있어도 카메라를 만난 것으로 간주
    // - 차량의 진입 지점, 진출 지점은 -30,000 이상 30,000 이하

    public int solution(int[][] routes) {
        // TODO: 풀이 작성
        return 0;
    }

    // ===== 아래는 채점용. 풀이만 위에서 수정하면 됩니다 =====

    public static void main(String[] args) {
        Ex034_42884 s = new Ex034_42884();

        check(1, s.solution(new int[][]{{-20, -15}, {-14, -5}, {-18, -13}, {-5, -3}}), 2);
    }

    private static void check(int no, int actual, int expected) {
        System.out.printf("예 #%d  [%s]  기대값=%s  내결과=%s%n",
                no, actual == expected ? "PASS" : "FAIL", expected, actual);
    }
}
