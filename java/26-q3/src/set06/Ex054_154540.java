package src.set06;

import java.util.*;

public class Ex054_154540 {

    // 문제: 무인도 여행
    // https://school.programmers.co.kr/learn/courses/30/lessons/154540
    // 키워드: DFS·BFS·그래프 이론 - 섬(연결 요소)마다 식량 합을 구해 오름차순 정렬
    // 레벨: Lv.2 (코딩테스트 공부 - 그래프)
    //
    // 제한사항
    // - 3 <= maps의 길이 <= 100
    // - 3 <= maps[i]의 길이 <= 100
    // - maps[i]는 'X' 또는 1과 9 사이의 자연수로 이루어진 문자열
    // - 지도는 직사각형 형태
    // - 각 섬에서 최대 며칠씩 머물 수 있는지를 오름차순으로 담은 배열을 return
    // - 만약 지낼 수 있는 무인도가 없다면 -1을 배열에 담아 return

    public int[] solution(String[] maps) {
        // TODO: 풀이 작성
        return new int[0];
    }

    // ===== 아래는 채점용. 풀이만 위에서 수정하면 됩니다 =====

    public static void main(String[] args) {
        Ex054_154540 s = new Ex054_154540();

        check(1, s.solution(new String[]{"X591X", "X1X5X", "X231X", "1XXX1"}),
                new int[]{1, 1, 27});
        check(2, s.solution(new String[]{"XXX", "XXX", "XXX"}), new int[]{-1});
    }

    private static void check(int no, int[] actual, int[] expected) {
        System.out.printf("예 #%d  [%s]  기대값=%s  내결과=%s%n",
                no, Arrays.equals(actual, expected) ? "PASS" : "FAIL",
                Arrays.toString(expected), Arrays.toString(actual));
    }
}
