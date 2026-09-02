package src.set07;

import java.util.*;

public class Ex062_150365 {

    // 문제: 미로 탈출 명령어
    // https://school.programmers.co.kr/learn/courses/30/lessons/150365
    // 키워드: BFS·그리디 - 정확히 k번 움직이는 사전순 최소 경로. d < l < r < u 순으로 탐욕 선택
    // 레벨: Lv.3 (2022 KAKAO TECH INTERNSHIP)
    //
    // 제한사항
    // - 2 <= n (미로의 세로 길이) <= 50
    // - 2 <= m (미로의 가로 길이) <= 50
    // - 1 <= x <= n, 1 <= y <= m  (현재 위치)
    // - 1 <= r <= n, 1 <= c <= m  (목표 위치)
    // - (x, y) != (r, c)
    // - 1 <= k <= 2,500
    // - 이동 거리가 정확히 k인 경로가 없으면 "impossible"을 return

    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        // TODO: 풀이 작성
        return "";
    }

    // ===== 아래는 채점용. 풀이만 위에서 수정하면 됩니다 =====

    public static void main(String[] args) {
        Ex062_150365 s = new Ex062_150365();

        check(1, s.solution(3, 4, 2, 3, 3, 1, 5), "dllrl");
        check(2, s.solution(2, 2, 1, 1, 2, 2, 2), "dr");
        check(3, s.solution(3, 3, 1, 2, 3, 3, 4), "impossible");
    }

    private static void check(int no, String actual, String expected) {
        System.out.printf("예 #%d  [%s]  기대값=%s  내결과=%s%n",
                no, Objects.equals(actual, expected) ? "PASS" : "FAIL", expected, actual);
    }
}
