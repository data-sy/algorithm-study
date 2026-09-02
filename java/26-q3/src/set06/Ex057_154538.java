package src.set06;

import java.util.*;

public class Ex057_154538 {

    // 문제: 숫자 변환하기
    // https://school.programmers.co.kr/learn/courses/30/lessons/154538
    // 키워드: BFS·DP - x에 +n, *2, *3을 적용해 y를 만드는 최소 연산 횟수 (불가능하면 -1)
    // 레벨: Lv.2 (코딩테스트 공부 - 그래프)
    //
    // 제한사항
    // - 1 <= x <= y <= 1,000,000
    // - 1 <= n < y
    // - x를 y로 변환할 수 없다면 -1을 return

    public int solution(int x, int y, int n) {
        // TODO: 풀이 작성
        return 0;
    }

    // ===== 아래는 채점용. 풀이만 위에서 수정하면 됩니다 =====

    public static void main(String[] args) {
        Ex057_154538 s = new Ex057_154538();

        check(1, s.solution(10, 40, 5), 2);
        check(2, s.solution(10, 40, 30), 1);
        check(3, s.solution(2, 5, 4), -1);
    }

    private static void check(int no, int actual, int expected) {
        System.out.printf("예 #%d  [%s]  기대값=%s  내결과=%s%n",
                no, actual == expected ? "PASS" : "FAIL", expected, actual);
    }
}
