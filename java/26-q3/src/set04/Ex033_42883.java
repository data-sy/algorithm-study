package src.set04;

import java.util.*;

public class Ex033_42883 {

    // 문제: 큰 수 만들기
    // https://school.programmers.co.kr/learn/courses/30/lessons/42883
    // 키워드: 그리디·스택 - 뒤에 더 큰 수가 오면 앞의 작은 수를 스택에서 빼며 k개를 제거
    // 레벨: Lv.2 (탐욕법)
    //
    // 제한사항
    // - number는 2자리 이상, 1,000,000자리 이하인 숫자
    // - k는 1 이상 number의 자릿수 미만인 자연수

    public String solution(String number, int k) {
        // TODO: 풀이 작성
        return "";
    }

    // ===== 아래는 채점용. 풀이만 위에서 수정하면 됩니다 =====

    public static void main(String[] args) {
        Ex033_42883 s = new Ex033_42883();

        check(1, s.solution("1924", 2), "94");
        check(2, s.solution("1231234", 3), "3234");
        check(3, s.solution("4177252841", 4), "775841");
    }

    private static void check(int no, String actual, String expected) {
        System.out.printf("예 #%d  [%s]  기대값=%s  내결과=%s%n",
                no, Objects.equals(actual, expected) ? "PASS" : "FAIL", expected, actual);
    }
}
