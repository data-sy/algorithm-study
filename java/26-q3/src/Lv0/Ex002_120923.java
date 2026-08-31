package src.Lv0;

import java.util.*;

public class Ex002_120923 {

    // 문제: 연속된 수의 합
    // https://school.programmers.co.kr/learn/courses/30/lessons/120923
    // 키워드: 수학 - 연속한 num개의 정수의 합이 total이 되는 수열
    // 레벨: Lv.0 (코딩테스트 입문)
    //
    // 제한사항
    // - 1 <= num <= 100
    // - 0 <= total <= 1000
    // - num개의 연속된 수를 더하여 total이 될 수 없는 테스트 케이스는 없음

    public int[] solution(int num, int total) {
        int[] answer = new int[num];
        int first = total/num - (num-1)/2;
        for (int i=0; i<num; i++) {
            answer[i] = first++;
        }

        return answer;
    }

    // 느낀 점
    // 이 문제에서는 상쇄되어 영향을 미치지는 않지만, 정수 간 나눗셈은 절사 몫임을 주의
    // num이 짝수이면 total/num에서 0.5가 버려지는데 (num-1)/2에서도 0.5가 버려져서 상쇄됨

    // ===== 아래는 채점용. 풀이만 위에서 수정하면 됩니다 =====

    public static void main(String[] args) {
        Ex002_120923 s = new Ex002_120923();

        check(1, s.solution(3, 12), new int[]{3, 4, 5});
        check(2, s.solution(5, 15), new int[]{1, 2, 3, 4, 5});
        check(3, s.solution(4, 14), new int[]{2, 3, 4, 5});
        check(4, s.solution(5, 5), new int[]{-1, 0, 1, 2, 3});
    }

    private static void check(int no, int[] actual, int[] expected) {
        System.out.printf("예 #%d  [%s]  기대값=%s  내결과=%s%n",
                no, Arrays.equals(actual, expected) ? "PASS" : "FAIL",
                Arrays.toString(expected), Arrays.toString(actual));
    }
}
