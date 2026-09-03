package src.set08;

import java.util.*;

public class Ex073_70129 {

    // 문제: 이진 변환 반복하기
    // https://school.programmers.co.kr/learn/courses/30/lessons/70129

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
