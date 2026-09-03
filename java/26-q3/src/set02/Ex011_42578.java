package src.set02;

import java.util.*;

public class Ex011_42578 {

    // 문제: 의상
    // https://school.programmers.co.kr/learn/courses/30/lessons/42578
    // 키워드: 해시·수학 - 종류별 개수를 세고 (개수+1)의 곱에서 아무것도 안 입은 1가지를 뺀다
    // 레벨: Lv.2 (해시)
    //
    // 제한사항
    // - clothes의 각 행은 [의상의 이름, 의상의 종류]로 이루어져 있음
    // - 코니가 가진 의상의 수는 1개 이상 30개 이하
    // - 같은 이름을 가진 의상은 존재하지 않음
    // - 모든 문자열의 길이는 1 이상 20 이하이고 알파벳 소문자 또는 '_'로만 이루어짐

    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> map = new HashMap<>();
        for (String[] cloth : clothes) {
            String type = cloth[1];
            map.put(type, map.getOrDefault(type, 0) + 1);
        }
        for (Integer count : map.values()) {
            answer *= ++count;
        }
        answer--;
        return answer;
    }

    // ===== 아래는 채점용. 풀이만 위에서 수정하면 됩니다 =====

    public static void main(String[] args) {
        Ex011_42578 s = new Ex011_42578();

        check(1, s.solution(new String[][]{
                {"yellow_hat", "headgear"},
                {"blue_sunglasses", "eyewear"},
                {"green_turban", "headgear"}}), 5);
        check(2, s.solution(new String[][]{
                {"crow_mask", "face"},
                {"blue_sunglasses", "face"},
                {"smoky_makeup", "face"}}), 3);
    }

    private static void check(int no, int actual, int expected) {
        System.out.printf("예 #%d  [%s]  기대값=%s  내결과=%s%n",
                no, actual == expected ? "PASS" : "FAIL", expected, actual);
    }
}
