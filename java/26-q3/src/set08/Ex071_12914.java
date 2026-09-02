package src.set08;

import java.util.*;

public class Ex071_12914 {

    // 문제: 멀리 뛰기
    // https://school.programmers.co.kr/learn/courses/30/lessons/12914
    // 키워드: DP - 1칸 또는 2칸씩. 결국 피보나치이며 1234567로 나눈 나머지를 반환
    // 레벨: Lv.2 (연습문제)
    //
    // 제한사항
    // - n은 1 이상, 2000 이하인 정수
    // - 방법의 수를 1234567로 나눈 나머지를 return

    public long solution(int n) {
        // TODO: 풀이 작성
        return 0L;
    }

    // ===== 아래는 채점용. 풀이만 위에서 수정하면 됩니다 =====

    public static void main(String[] args) {
        Ex071_12914 s = new Ex071_12914();

        check(1, s.solution(4), 5L);
        check(2, s.solution(3), 3L);
    }

    private static void check(int no, long actual, long expected) {
        System.out.printf("예 #%d  [%s]  기대값=%s  내결과=%s%n",
                no, actual == expected ? "PASS" : "FAIL", expected, actual);
    }
}
