package src.Lv0;

import java.util.*;

public class Ex007_120875 {

    // 문제: 평행
    // https://school.programmers.co.kr/learn/courses/30/lessons/120875
    // 키워드: 기하 - 네 점을 두 개씩 짝지어 만든 두 직선이 평행한 경우가 있는지
    // 레벨: Lv.0 (코딩테스트 입문)
    //
    // 제한사항
    // - dots의 길이 = 4, 원소는 [x, y] 형태이며 0 <= x, y <= 100인 정수
    // - 서로 다른 두 개 이상의 점이 겹치는 경우는 없음
    // - 두 직선이 겹치는 경우(일치하는 경우)에도 1을 return
    // - 임의의 두 점을 이은 직선이 x축 또는 y축과 평행한 경우는 주어지지 않음

    public int solution(int[][] dots) {
        // dot0, 1을 연결한 선분을 01이라고 했을 때
        // 선분 01 vs 23 , 02 vs 13, 03 vs 12 : 평행인지 비교 (3가지). 이 중 하나라도 같은 게 있다면 평행 있는 것
        double[] gradients = new double[6];
        int k = 0;
        for (int i=0; i<dots.length; i++) {
            for (int j=i+1; j<dots.length; j++) {
                gradients[k] = gradient(dots[i], dots[j]);
                k++;
            }
        }
        // gradients에 01, 02, 03, 12, 13, 23 순서로 기울기가 들어 있음
        if(gradients[0]==gradients[5] || gradients[1]==gradients[4] || gradients[2]==gradients[3]) return 1;

        return 0;
    }

    public double gradient(int[] dot1, int[] dot2){
        double dx = dot1[0] - dot2[0];
        double dy = dot1[1] - dot2[1];
        return dy/dx;
    }

    // 느낀 점 — 첫 풀이 때 놓친 점
    // 문제 조건을 정확하게 이해해야 해. '2개씩' 짝을 지었을 때 평행
    //   O : (a, b) (c, d)
    //   X : (a, b) (b, c)
    // 그래서 set을 사용해서 평행 유무 확인하면 한 점이 중복사용 되는 경우도 포함되어 있어서 틀림

    // ===== 아래는 채점용. 풀이만 위에서 수정하면 됩니다 =====

    public static void main(String[] args) {
        Ex007_120875 s = new Ex007_120875();

        check(1, s.solution(new int[][]{{1, 4}, {9, 2}, {3, 8}, {11, 6}}), 1);
        check(2, s.solution(new int[][]{{3, 5}, {4, 1}, {2, 4}, {5, 10}}), 0);
    }

    private static void check(int no, int actual, int expected) {
        System.out.printf("예 #%d  [%s]  기대값=%d  내결과=%d%n",
                no, actual == expected ? "PASS" : "FAIL", expected, actual);
    }
}
