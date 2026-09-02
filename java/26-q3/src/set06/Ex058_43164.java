package src.set06;

import java.util.*;

public class Ex058_43164 {

    // 문제: 여행경로
    // https://school.programmers.co.kr/learn/courses/30/lessons/43164
    // 키워드: DFS·백트래킹·그래프 이론 - ICN에서 시작해 모든 항공권을 쓰는 사전순 최소 경로
    // 레벨: Lv.3 (깊이/너비 우선 탐색(DFS/BFS))
    //
    // 제한사항
    // - 모든 공항은 알파벳 대문자 3글자로 이루어짐
    // - 주어진 공항 수는 3개 이상 10,000개 이하
    // - tickets의 각 행 [a, b]는 a 공항에서 b 공항으로 가는 항공권이 있다는 의미
    // - 주어진 항공권은 모두 사용해야 함
    // - 만일 가능한 경로가 2개 이상일 경우 알파벳 순서가 앞서는 경로를 return
    // - 모든 도시를 방문할 수 없는 경우는 주어지지 않음

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
