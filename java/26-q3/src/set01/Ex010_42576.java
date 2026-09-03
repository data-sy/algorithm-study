package src.set01;

import java.util.*;

public class Ex010_42576 {

    // 문제: 완주하지 못한 선수
    // https://school.programmers.co.kr/learn/courses/30/lessons/42576

    public String solution(String[] participant, String[] completion) {
//        // 배열 그대로 사용한다면
//        // 시간복잡도 O(n^2) 라서 정확성 테스트는 통과하지만 효율성 테스트는 통과 못함
//        String answer = "";
//        for (int i = 0; i < completion.length; i++) {
//            for (int j = 0; j < participant.length; j++) {
//                if (completion[i].equals(participant[j])) {
//                    participant[j]=null;
//                    break;
//                }
//            }
//        }
//        for (int i = 0; i < participant.length; i++) {
//            if (participant[i]!=null) {
//                answer = participant[i];
//            }
//        }
//        return answer;
        String answer = "변화없음";
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < participant.length; i++) {
            map.put(participant[i], map.getOrDefault(participant[i], 0) + 1);
        }
        for (int i = 0; i < completion.length; i++) {
            map.put(completion[i], map.getOrDefault(completion[i], 0) - 1);
        }
        for (String key : map.keySet()) {
            if (map.get(key) != 0) {
                answer = key;
                break;
            }
        }
        return answer;
    }

    // ===== 아래는 채점용. 풀이만 위에서 수정하면 됩니다 =====

    public static void main(String[] args) {
        Ex010_42576 s = new Ex010_42576();

        check(1, s.solution(
                new String[]{"leo", "kiki", "eden"},
                new String[]{"eden", "kiki"}), "leo");
        check(2, s.solution(
                new String[]{"marina", "josipa", "nikola", "vinko", "filipa"},
                new String[]{"josipa", "filipa", "marina", "nikola"}), "vinko");
        check(3, s.solution(
                new String[]{"mislav", "stanko", "mislav", "ana"},
                new String[]{"stanko", "ana", "mislav"}), "mislav");
    }

    private static void check(int no, String actual, String expected) {
        System.out.printf("예 #%d  [%s]  기대값=%s  내결과=%s%n",
                no, Objects.equals(actual, expected) ? "PASS" : "FAIL", expected, actual);
    }
}
