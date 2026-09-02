package src.set02;

import java.util.*;

public class Ex012_42577 {

    // 문제: 전화번호 목록
    // https://school.programmers.co.kr/learn/courses/30/lessons/42577
    // 키워드: 해시·정렬·트라이 - 어떤 번호가 다른 번호의 접두어인지 판별
    // 레벨: Lv.2 (해시)
    //
    // 제한사항
    // - phone_book의 길이는 1 이상 1,000,000 이하
    // - 각 전화번호의 길이는 1 이상 20 이하
    // - 같은 전화번호가 중복해서 들어있지 않음

    public boolean solution(String[] phone_book) {
        // TODO: 풀이 작성
        return false;
    }

    // ===== 아래는 채점용. 풀이만 위에서 수정하면 됩니다 =====

    public static void main(String[] args) {
        Ex012_42577 s = new Ex012_42577();

        check(1, s.solution(new String[]{"119", "97674223", "1195524421"}), false);
        check(2, s.solution(new String[]{"123", "456", "789"}), true);
        check(3, s.solution(new String[]{"12", "123", "1235", "567", "88"}), false);
    }

    private static void check(int no, boolean actual, boolean expected) {
        System.out.printf("예 #%d  [%s]  기대값=%s  내결과=%s%n",
                no, actual == expected ? "PASS" : "FAIL", expected, actual);
    }
}
