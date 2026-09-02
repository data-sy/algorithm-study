package src.set03;

import java.util.*;

public class Ex025_131127 {

    // 문제: 할인 행사
    // https://school.programmers.co.kr/learn/courses/30/lessons/131127
    // 키워드: 슬라이딩 윈도우·해시 - 길이 10짜리 창을 밀며 원하는 수량과 일치하는 날을 센다
    // 레벨: Lv.2 (연습문제)
    //
    // 제한사항
    // - 1 <= want의 길이 = number의 길이 <= 10
    // - 1 <= number의 원소 <= 10, number의 원소 합은 10
    // - 10 <= discount의 길이 <= 100,000
    // - want와 discount의 원소들은 알파벳 소문자로 이루어진 문자열
    //   (1 <= want의 원소의 길이, discount의 원소의 길이 <= 12)

    public int solution(String[] want, int[] number, String[] discount) {
        // TODO: 풀이 작성
        return 0;
    }

    // ===== 아래는 채점용. 풀이만 위에서 수정하면 됩니다 =====

    public static void main(String[] args) {
        Ex025_131127 s = new Ex025_131127();

        check(1, s.solution(
                new String[]{"banana", "apple", "rice", "pork", "pot"},
                new int[]{3, 2, 2, 2, 1},
                new String[]{"chicken", "apple", "apple", "banana", "rice", "apple", "pork",
                        "banana", "pork", "rice", "pot", "banana", "apple", "banana"}), 3);
        check(2, s.solution(
                new String[]{"apple"},
                new int[]{10},
                new String[]{"banana", "banana", "banana", "banana", "banana",
                        "banana", "banana", "banana", "banana", "banana"}), 0);
    }

    private static void check(int no, int actual, int expected) {
        System.out.printf("예 #%d  [%s]  기대값=%s  내결과=%s%n",
                no, actual == expected ? "PASS" : "FAIL", expected, actual);
    }
}
