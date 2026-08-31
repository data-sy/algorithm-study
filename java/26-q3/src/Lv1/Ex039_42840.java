package src.Lv1;

import java.util.*;

public class Ex039_42840 {

    // 문제: 모의고사
    // https://school.programmers.co.kr/learn/courses/30/lessons/42840
    // 키워드: 브루트포싱 - 세 수포자의 찍기 패턴을 각각 돌려 최고 득점자를 고른다
    // 레벨: Lv.1 (완전탐색)
    //
    // 제한사항
    // - 시험은 최대 10,000 문제로 구성되어 있음
    // - 문제의 정답은 1, 2, 3, 4, 5 중 하나
    // - 가장 높은 점수를 받은 사람이 여럿일 경우, return하는 값을 오름차순 정렬

    public int[] solution(int[] answers) {
        // TODO: 풀이 작성
        return new int[0];
    }

    // ===== 아래는 채점용. 풀이만 위에서 수정하면 됩니다 =====

    public static void main(String[] args) {
        Ex039_42840 s = new Ex039_42840();

        check(1, s.solution(new int[]{1, 2, 3, 4, 5}), new int[]{1});
        check(2, s.solution(new int[]{1, 3, 2, 4, 2}), new int[]{1, 2, 3});
    }

    private static void check(int no, int[] actual, int[] expected) {
        System.out.printf("예 #%d  [%s]  기대값=%s  내결과=%s%n",
                no, Arrays.equals(actual, expected) ? "PASS" : "FAIL",
                Arrays.toString(expected), Arrays.toString(actual));
    }
}
