package src.Lv3;

import java.util.*;

public class Ex027_67258 {

    // 문제: 보석 쇼핑
    // https://school.programmers.co.kr/learn/courses/30/lessons/67258
    // 키워드: 투 포인터·슬라이딩 윈도우·해시 - 모든 종류를 담는 최단 구간 (1-indexed, 동률이면 앞선 구간)
    // 레벨: Lv.3 (2020 카카오 인턴십)
    //
    // 제한사항
    // - gems 배열의 크기는 1 이상 100,000 이하
    // - gems 배열의 각 원소는 진열대에 나열된 보석을 나타내는 대문자 알파벳 문자열
    //   (1 이상 10 이하 길이)
    // - gems 배열에는 서로 다른 이름을 가진 보석이 최소 1가지 이상 존재
    // - 답이 여러 가지인 경우 시작 진열대 번호가 가장 작은 구간을 return

    public int[] solution(String[] gems) {
        // TODO: 풀이 작성
        return new int[0];
    }

    // ===== 아래는 채점용. 풀이만 위에서 수정하면 됩니다 =====

    public static void main(String[] args) {
        Ex027_67258 s = new Ex027_67258();

        check(1, s.solution(new String[]{"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"}),
                new int[]{3, 7});
        check(2, s.solution(new String[]{"AA", "AB", "AC", "AA", "AC"}), new int[]{1, 3});
        check(3, s.solution(new String[]{"XYZ", "XYZ", "XYZ"}), new int[]{1, 1});
        check(4, s.solution(new String[]{"ZZZ", "YYY", "NNNN", "YYY", "BBB"}), new int[]{1, 5});
    }

    private static void check(int no, int[] actual, int[] expected) {
        System.out.printf("예 #%d  [%s]  기대값=%s  내결과=%s%n",
                no, Arrays.equals(actual, expected) ? "PASS" : "FAIL",
                Arrays.toString(expected), Arrays.toString(actual));
    }
}
