package src.set01;

import java.util.*;

public class Ex009_120956 {

    // 문제: 옹알이 (1)
    // https://school.programmers.co.kr/learn/courses/30/lessons/120956
    String[] words = {"aya", "ye", "woo", "ma"};

    public int solution(String[] babbling) {
        int answer = 0;
        for  (String check : babbling) {
            answer += recur(check);
        }
        return answer;
    }

    int recur(String check) {
        if(check.isEmpty()) return 1;

        for (String word : words) {
            if(check.startsWith(word)) {
                check = check.substring(word.length(), check.length());
                if (recur(check)==1) return 1;
            }
        }

        return 0;
    }

    // ===== 아래는 채점용. 풀이만 위에서 수정하면 됩니다 =====

    public static void main(String[] args) {
        Ex009_120956 s = new Ex009_120956();

        check(1, s.solution(new String[]{"aya", "yee", "u", "maa", "wyeoo"}), 1);
        check(2, s.solution(new String[]{"ayaye", "uuuma", "ye", "yemawoo", "ayaa"}), 3);
    }

    private static void check(int no, int actual, int expected) {
        System.out.printf("예 #%d  [%s]  기대값=%d  내결과=%d%n",
                no, actual == expected ? "PASS" : "FAIL", expected, actual);
    }
}
