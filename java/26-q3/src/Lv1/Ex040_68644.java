package src.Lv1;

import java.util.*;

public class Ex040_68644 {

    // 문제: 두 개 뽑아서 더하기
    // https://school.programmers.co.kr/learn/courses/30/lessons/68644
    // 키워드: 브루트포싱·조합 - 서로 다른 두 인덱스의 합을 중복 없이 모아 오름차순 정렬
    // 레벨: Lv.1 (월간 코드 챌린지 시즌1)
    //
    // 제한사항
    // - numbers의 길이는 2 이상 100 이하
    // - numbers의 모든 수는 0 이상 100 이하

    public int[] solution(int[] numbers) {
        // TODO: 풀이 작성
        return new int[0];
    }

    // ===== 아래는 채점용. 풀이만 위에서 수정하면 됩니다 =====

    public static void main(String[] args) {
        Ex040_68644 s = new Ex040_68644();

        check(1, s.solution(new int[]{2, 1, 3, 4, 1}), new int[]{2, 3, 4, 5, 6, 7});
        check(2, s.solution(new int[]{5, 0, 2, 7}), new int[]{2, 5, 7, 9, 12});
    }

    private static void check(int no, int[] actual, int[] expected) {
        System.out.printf("예 #%d  [%s]  기대값=%s  내결과=%s%n",
                no, Arrays.equals(actual, expected) ? "PASS" : "FAIL",
                Arrays.toString(expected), Arrays.toString(actual));
    }
}
