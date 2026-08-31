package src.Lv2;

import java.util.*;

public class Ex023_42746 {

    // 문제: 가장 큰 수
    // https://school.programmers.co.kr/learn/courses/30/lessons/42746
    // 키워드: 정렬·문자열 - (b+a) vs (a+b) 비교로 이어붙인 결과가 커지는 순서로 정렬
    // 레벨: Lv.2 (정렬)
    //
    // 제한사항
    // - numbers의 길이는 1 이상 100,000 이하
    // - numbers의 원소는 0 이상 1,000 이하
    // - 정답이 너무 클 수 있으니 문자열로 바꾸어 return

    public String solution(int[] numbers) {
        // TODO: 풀이 작성
        return "";
    }

    // ===== 아래는 채점용. 풀이만 위에서 수정하면 됩니다 =====

    public static void main(String[] args) {
        Ex023_42746 s = new Ex023_42746();

        check(1, s.solution(new int[]{6, 10, 2}), "6210");
        check(2, s.solution(new int[]{3, 30, 34, 5, 9}), "9534330");
    }

    private static void check(int no, String actual, String expected) {
        System.out.printf("예 #%d  [%s]  기대값=%s  내결과=%s%n",
                no, Objects.equals(actual, expected) ? "PASS" : "FAIL", expected, actual);
    }
}
