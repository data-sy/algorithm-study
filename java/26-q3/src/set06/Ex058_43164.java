package src.set06;

import java.util.*;

public class Ex058_43164 {

    // 문제: 여행경로
    // https://school.programmers.co.kr/learn/courses/30/lessons/43164

    public String[] solution(String[][] tickets) {
        // TODO: 풀이 작성
        return new String[0];
    }

    // ===== 아래는 채점용. 풀이만 위에서 수정하면 됩니다 =====

    public static void main(String[] args) {
        Ex058_43164 s = new Ex058_43164();

        check(1, s.solution(new String[][]{
                {"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}}),
                new String[]{"ICN", "JFK", "HND", "IAD"});
        check(2, s.solution(new String[][]{
                {"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}}),
                new String[]{"ICN", "ATL", "ICN", "SFO", "ATL", "SFO"});
    }

    private static void check(int no, String[] actual, String[] expected) {
        System.out.printf("예 #%d  [%s]  기대값=%s  내결과=%s%n",
                no, Arrays.equals(actual, expected) ? "PASS" : "FAIL",
                Arrays.toString(expected), Arrays.toString(actual));
    }
}
