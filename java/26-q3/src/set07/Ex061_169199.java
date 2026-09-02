package src.set07;

import java.util.*;

public class Ex061_169199 {

    // 문제: 리코쳇 로봇
    // https://school.programmers.co.kr/learn/courses/30/lessons/169199
    // 키워드: BFS·그래프 이론 - 한 번 미끄러지면 장애물/벽에 부딪힐 때까지 직진 (한 칸이 아님)
    // 레벨: Lv.2 (연습문제)
    //
    // 제한사항
    // - 3 <= board의 길이 <= 100
    // - 3 <= board의 원소의 길이 <= 100
    // - board의 원소의 길이는 모두 동일
    // - 문자열은 '.', 'D', 'R', 'G'로만 구성
    //   '.' = 빈 공간, 'D' = 장애물, 'R' = 로봇의 처음 위치, 'G' = 목표 지점
    // - 'R'과 'G'는 한 번씩 등장
    // - 목표 지점에 도달할 수 없다면 -1을 return

    public int solution(String[] board) {
        // TODO: 풀이 작성
        return 0;
    }

    // ===== 아래는 채점용. 풀이만 위에서 수정하면 됩니다 =====

    public static void main(String[] args) {
        Ex061_169199 s = new Ex061_169199();

        check(1, s.solution(new String[]{"...D..R", ".D.G...", "....D.D", "D....D.", "..D...."}), 7);
        check(2, s.solution(new String[]{".D.R", "....", ".G..", "...D"}), -1);
    }

    private static void check(int no, int actual, int expected) {
        System.out.printf("예 #%d  [%s]  기대값=%s  내결과=%s%n",
                no, actual == expected ? "PASS" : "FAIL", expected, actual);
    }
}
