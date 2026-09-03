package src.set06;

import java.util.*;

public class Ex052_43163 {

    // 문제: 단어 변환
    // https://school.programmers.co.kr/learn/courses/30/lessons/43163

    public int solution(String begin, String target, String[] words) {
        // TODO: 풀이 작성
        return 0;
    }

    // ===== 아래는 채점용. 풀이만 위에서 수정하면 됩니다 =====

    public static void main(String[] args) {
        Ex052_43163 s = new Ex052_43163();

        check(1, s.solution("hit", "cog",
                new String[]{"hot", "dot", "dog", "lot", "log", "cog"}), 4);
        check(2, s.solution("hit", "cog",
                new String[]{"hot", "dot", "dog", "lot", "log"}), 0);
    }

    private static void check(int no, int actual, int expected) {
        System.out.printf("예 #%d  [%s]  기대값=%s  내결과=%s%n",
                no, actual == expected ? "PASS" : "FAIL", expected, actual);
    }
}
