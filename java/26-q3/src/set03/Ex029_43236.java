package src.set03;

import java.util.*;

public class Ex029_43236 {

    // 문제: 징검다리
    // https://school.programmers.co.kr/learn/courses/30/lessons/43236
    // 키워드: 이분 탐색·그리디 - "최소 간격이 D 이상이 되게 n개 이하로 제거 가능한가"를 판정
    // 레벨: Lv.4 (이분탐색)
    //
    // 제한사항
    // - 도착지점까지의 거리 distance는 1 이상 1,000,000,000 이하
    // - 바위는 1개 이상 50,000개 이하가 있음
    // - n은 1 이상 바위의 개수 이하

    public int solution(int distance, int[] rocks, int n) {
        // TODO: 풀이 작성
        return 0;
    }

    // ===== 아래는 채점용. 풀이만 위에서 수정하면 됩니다 =====

    public static void main(String[] args) {
        Ex029_43236 s = new Ex029_43236();

        check(1, s.solution(25, new int[]{2, 14, 11, 21, 17}, 2), 4);
    }

    private static void check(int no, int actual, int expected) {
        System.out.printf("예 #%d  [%s]  기대값=%s  내결과=%s%n",
                no, actual == expected ? "PASS" : "FAIL", expected, actual);
    }
}
