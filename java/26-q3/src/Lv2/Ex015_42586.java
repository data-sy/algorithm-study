package src.Lv2;

import java.util.*;

public class Ex015_42586 {

    // 문제: 기능개발
    // https://school.programmers.co.kr/learn/courses/30/lessons/42586
    // 키워드: 큐·시뮬레이션 - 앞 기능이 끝나야 배포되므로 앞선 완료일보다 늦어지는 지점에서 끊는다
    // 레벨: Lv.2 (스택/큐)
    //
    // 제한사항
    // - 작업의 개수(progresses, speeds 배열의 길이)는 100개 이하
    // - 작업 진도는 100 미만의 자연수
    // - 작업 속도는 100 이하의 자연수
    // - 배포는 하루에 한 번만 할 수 있으며, 하루의 끝에 이루어진다고 가정

    public int[] solution(int[] progresses, int[] speeds) {
        // TODO: 풀이 작성
        return new int[0];
    }

    // ===== 아래는 채점용. 풀이만 위에서 수정하면 됩니다 =====

    public static void main(String[] args) {
        Ex015_42586 s = new Ex015_42586();

        check(1, s.solution(new int[]{93, 30, 55}, new int[]{1, 30, 5}),
                new int[]{2, 1});
        check(2, s.solution(new int[]{95, 90, 99, 99, 80, 99}, new int[]{1, 1, 1, 1, 1, 1}),
                new int[]{1, 3, 2});
    }

    private static void check(int no, int[] actual, int[] expected) {
        System.out.printf("예 #%d  [%s]  기대값=%s  내결과=%s%n",
                no, Arrays.equals(actual, expected) ? "PASS" : "FAIL",
                Arrays.toString(expected), Arrays.toString(actual));
    }
}
