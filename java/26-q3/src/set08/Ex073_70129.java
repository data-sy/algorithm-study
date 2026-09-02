package src.set08;

import java.util.*;

public class Ex073_70129 {

    // 문제: 이진 변환 반복하기
    // https://school.programmers.co.kr/learn/courses/30/lessons/70129
    // 키워드: 구현·시뮬레이션 - 0을 지우고 남은 1의 개수를 이진수로 바꾸기를 "1"이 될 때까지
    // 레벨: Lv.2 (월간 코드 챌린지 시즌1)
    //
    // 제한사항
    // - s의 길이는 1 이상 150,000 이하이며 '0'과 '1'로 이루어진 문자열
    // - s에는 '1'이 최소 하나 이상 포함되어 있음
    // - 반환값은 [이진 변환의 횟수, 제거된 모든 0의 개수]

    public int[] solution(String s) {
        // TODO: 풀이 작성
        return new int[0];
    }

    // ===== 아래는 채점용. 풀이만 위에서 수정하면 됩니다 =====

    public static void main(String[] args) {
        Ex073_70129 s = new Ex073_70129();

        check(1, s.solution("110010101001"), new int[]{3, 8});
        check(2, s.solution("01110"), new int[]{3, 3});
        check(3, s.solution("1111111"), new int[]{4, 1});
    }

    private static void check(int no, int[] actual, int[] expected) {
        System.out.printf("예 #%d  [%s]  기대값=%s  내결과=%s%n",
                no, Arrays.equals(actual, expected) ? "PASS" : "FAIL",
                Arrays.toString(expected), Arrays.toString(actual));
    }
}
