package src.set02;

import java.util.*;

public class Ex013_42579 {

    // 문제: 베스트앨범
    // https://school.programmers.co.kr/learn/courses/30/lessons/42579
    // 키워드: 해시·정렬 - 장르별 총 재생수 내림차순, 장르 안에서는 재생수(동률이면 고유번호)로 최대 2곡
    // 레벨: Lv.3 (해시)
    //
    // 제한사항
    // - genres[i]는 고유번호가 i인 노래의 장르
    // - plays[i]는 고유번호가 i인 노래가 재생된 횟수
    // - genres와 plays의 길이는 같으며, 1 이상 10,000 이하
    // - 장르 종류는 100개 미만
    // - 장르에 속한 곡이 하나라면 하나의 곡만 선택
    // - 모든 장르는 재생된 횟수가 다름

    public int[] solution(String[] genres, int[] plays) {
        // TODO: 풀이 작성
        return new int[0];
    }

    // ===== 아래는 채점용. 풀이만 위에서 수정하면 됩니다 =====

    public static void main(String[] args) {
        Ex013_42579 s = new Ex013_42579();

        check(1, s.solution(
                new String[]{"classic", "pop", "classic", "classic", "pop"},
                new int[]{500, 600, 150, 800, 2500}), new int[]{4, 1, 3, 0});
    }

    private static void check(int no, int[] actual, int[] expected) {
        System.out.printf("예 #%d  [%s]  기대값=%s  내결과=%s%n",
                no, Arrays.equals(actual, expected) ? "PASS" : "FAIL",
                Arrays.toString(expected), Arrays.toString(actual));
    }
}
