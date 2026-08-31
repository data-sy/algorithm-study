package src.Lv2;

import java.util.*;

public class Ex017_42587 {

    // 문제: 프로세스
    // https://school.programmers.co.kr/learn/courses/30/lessons/42587
    // 키워드: 큐·우선순위 큐·시뮬레이션 - 뒤에 더 높은 우선순위가 있으면 맨 뒤로 보낸다
    // 레벨: Lv.2 (스택/큐)
    //
    // 제한사항
    // - priorities의 길이는 1 이상 100 이하
    // - priorities의 원소는 1 이상 9 이하의 정수 (숫자가 클수록 우선순위가 높음)
    // - location은 0 이상 (대기 큐에 있는 프로세스 수 - 1) 이하

    public int solution(int[] priorities, int location) {
        // TODO: 풀이 작성
        return 0;
    }

    // ===== 아래는 채점용. 풀이만 위에서 수정하면 됩니다 =====

    public static void main(String[] args) {
        Ex017_42587 s = new Ex017_42587();

        check(1, s.solution(new int[]{2, 1, 3, 2}, 2), 1);
        check(2, s.solution(new int[]{1, 1, 9, 1, 1, 1}, 0), 5);
    }

    private static void check(int no, int actual, int expected) {
        System.out.printf("예 #%d  [%s]  기대값=%s  내결과=%s%n",
                no, actual == expected ? "PASS" : "FAIL", expected, actual);
    }
}
