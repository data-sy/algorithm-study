package src.set03;

import java.util.*;

public class Ex030_42862 {

    // 문제: 체육복
    // https://school.programmers.co.kr/learn/courses/30/lessons/42862
    // 키워드: 그리디 - 앞번호부터 빌려주되, 도난당한 여벌 보유자는 먼저 자기 몫으로 처리
    // 레벨: Lv.1 (탐욕법)
    //
    // 제한사항
    // - 전체 학생의 수는 2명 이상 30명 이하
    // - 체육복을 도난당한 학생의 수는 1명 이상 n명 이하이고 중복되는 번호는 없음
    // - 여벌의 체육복을 가져온 학생의 수는 1명 이상 n명 이하이고 중복되는 번호는 없음
    // - 여벌 체육복이 있는 학생만 다른 학생에게 체육복을 빌려줄 수 있음
    // - 여벌 체육복을 가져온 학생이 체육복을 도난당했을 수 있으며,
    //   이 경우 자신은 체육복을 빌려줄 수 없음

    public int solution(int n, int[] lost, int[] reserve) {
        // TODO: 풀이 작성
        return 0;
    }

    // ===== 아래는 채점용. 풀이만 위에서 수정하면 됩니다 =====

    public static void main(String[] args) {
        Ex030_42862 s = new Ex030_42862();

        check(1, s.solution(5, new int[]{2, 4}, new int[]{1, 3, 5}), 5);
        check(2, s.solution(5, new int[]{2, 4}, new int[]{3}), 4);
        check(3, s.solution(3, new int[]{3}, new int[]{1}), 2);
    }

    private static void check(int no, int actual, int expected) {
        System.out.printf("예 #%d  [%s]  기대값=%s  내결과=%s%n",
                no, actual == expected ? "PASS" : "FAIL", expected, actual);
    }
}
