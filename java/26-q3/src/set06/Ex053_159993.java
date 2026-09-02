package src.set06;

import java.util.*;

public class Ex053_159993 {

    // 문제: 미로 탈출
    // https://school.programmers.co.kr/learn/courses/30/lessons/159993
    // 키워드: BFS·최단 거리 - S→L 최단 + L→E 최단으로 쪼개서 각각 BFS
    // 레벨: Lv.2 (코딩테스트 공부 - 그래프)
    //
    // 제한사항
    // - 5 <= maps의 길이 <= 100
    // - 5 <= maps[i]의 길이 <= 100
    // - maps[i]는 'S', 'E', 'L', 'O', 'X'로 이루어진 문자열
    //   S = 시작 지점, E = 출구, L = 레버, O = 통로, X = 벽
    // - 지도에는 미로를 탈출하는 경로가 없는 경우도 있으며, 이때는 -1을 return
    // - S, E, L은 지도에 각각 하나씩만 존재

    public int solution(String[] maps) {
        // TODO: 풀이 작성
        return 0;
    }

    // ===== 아래는 채점용. 풀이만 위에서 수정하면 됩니다 =====

    public static void main(String[] args) {
        Ex053_159993 s = new Ex053_159993();

        check(1, s.solution(new String[]{"SOOOL", "XXXXO", "OOOOO", "OXXXX", "OOOOE"}), 16);
        check(2, s.solution(new String[]{"LOOXS", "OOOOX", "OOOOO", "OOOOO", "EOOOO"}), -1);
    }

    private static void check(int no, int actual, int expected) {
        System.out.printf("예 #%d  [%s]  기대값=%s  내결과=%s%n",
                no, actual == expected ? "PASS" : "FAIL", expected, actual);
    }
}
