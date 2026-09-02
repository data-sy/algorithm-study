package src.set02;

import java.util.*;

public class Ex019_42628 {

    // 문제: 이중우선순위큐
    // https://school.programmers.co.kr/learn/courses/30/lessons/42628
    // 키워드: 우선순위 큐·구현 - 최댓값과 최솟값을 모두 O(log n)에 꺼내는 큐
    // 레벨: Lv.3 (힙)
    //
    // 제한사항
    // - operations는 길이가 1 이상 1,000,000 이하인 문자열 배열
    // - operations의 원소는 큐가 수행할 연산을 나타냄
    //   "I 숫자" = 큐에 삽입, "D 1" = 최댓값 삭제, "D -1" = 최솟값 삭제
    // - 최댓값/최솟값이 여러 개면 하나만 삭제
    // - 빈 큐에 데이터를 삭제하라는 연산이 주어지면 무시

    public int[] solution(String[] operations) {
        // TODO: 풀이 작성
        return new int[0];
    }

    // ===== 아래는 채점용. 풀이만 위에서 수정하면 됩니다 =====

    public static void main(String[] args) {
        Ex019_42628 s = new Ex019_42628();

        check(1, s.solution(new String[]{"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"}),
                new int[]{0, 0});
        check(2, s.solution(new String[]{"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"}),
                new int[]{333, -45});
    }

    private static void check(int no, int[] actual, int[] expected) {
        System.out.printf("예 #%d  [%s]  기대값=%s  내결과=%s%n",
                no, Arrays.equals(actual, expected) ? "PASS" : "FAIL",
                Arrays.toString(expected), Arrays.toString(actual));
    }
}
