package src.Lv0;

import java.util.*;

public class Ex001_120956 {

    // 문제: 옹알이 (1)
    // https://school.programmers.co.kr/learn/courses/30/lessons/120956
    // 키워드: 문자열 - "aya", "ye", "woo", "ma" 를 최대 한 번씩 조합해 만든 단어인가
    // 레벨: Lv.0 (코딩테스트 입문)
    //
    // 제한사항
    // - 1 <= babbling.length <= 100
    // - 1 <= babbling[i].length <= 15
    // - babbling[i] 안에서 "aya", "ye", "woo", "ma" 는 각각 최대 한 번만 등장
    // - 알파벳 소문자로만 구성
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
        Ex001_120956 s = new Ex001_120956();

        check(1, s.solution(new String[]{"aya", "yee", "u", "maa", "wyeoo"}), 1);
        check(2, s.solution(new String[]{"ayaye", "uuuma", "ye", "yemawoo", "ayaa"}), 3);
    }

    private static void check(int no, int actual, int expected) {
        System.out.printf("예 #%d  [%s]  기대값=%d  내결과=%d%n",
                no, actual == expected ? "PASS" : "FAIL", expected, actual);
    }
}
