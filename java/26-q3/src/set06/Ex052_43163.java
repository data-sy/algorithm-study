package src.set06;

import java.util.*;

public class Ex052_43163 {

    // 문제: 단어 변환
    // https://school.programmers.co.kr/learn/courses/30/lessons/43163
    // 키워드: BFS·그래프 이론 - 한 글자만 다른 단어를 간선으로 보고 최단 변환 횟수
    // 레벨: Lv.3 (깊이/너비 우선 탐색(DFS/BFS))
    //
    // 제한사항
    // - 각 단어는 알파벳 소문자로만 이루어져 있음
    // - 각 단어의 길이는 3 이상 10 이하이며 모든 단어의 길이는 같음
    // - words에는 3개 이상 50개 이하의 단어가 있으며 중복되는 단어는 없음
    // - begin과 target은 같지 않음
    // - 변환할 수 없는 경우에는 0을 return

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
