package src.set06;

import java.util.*;

public class Ex060_150366 {

    // 문제: 표 병합
    // https://school.programmers.co.kr/learn/courses/30/lessons/150366
    // 키워드: 유니온-파인드·구현·시뮬레이션 - 병합된 셀 그룹을 대표 셀로 묶어 관리
    // 레벨: Lv.3 (2022 KAKAO TECH INTERNSHIP)
    //
    // 제한사항
    // - 1 <= commands의 길이 <= 1,000
    // - commands의 각 원소는 아래 다섯 가지 형태 중 하나
    //   "UPDATE r c value" / "UPDATE value1 value2" / "MERGE r1 c1 r2 c2"
    //   / "UNMERGE r c" / "PRINT r c"
    // - r, c, r1, c1, r2, c2는 1 이상 50 이하의 정수
    // - value, value1, value2는 알파벳 소문자와 숫자로 구성되며 길이는 1 이상 10 이하
    // - commands에는 1개 이상의 "PRINT r c" 명령이 포함
    // - 빈 셀을 PRINT하면 "EMPTY"를 결과에 담음

    public String[] solution(String[] commands) {
        // TODO: 풀이 작성
        return new String[0];
    }

    // ===== 아래는 채점용. 풀이만 위에서 수정하면 됩니다 =====

    public static void main(String[] args) {
        Ex060_150366 s = new Ex060_150366();

        check(1, s.solution(new String[]{
                "UPDATE 1 1 menu", "UPDATE 1 2 category", "UPDATE 2 1 bibimbap",
                "UPDATE 2 2 korean", "UPDATE 2 3 rice", "UPDATE 3 1 ramyeon",
                "UPDATE 3 2 korean", "UPDATE 3 3 noodle", "UPDATE 3 4 instant",
                "UPDATE 4 1 pasta", "UPDATE 4 2 italian", "UPDATE 4 3 noodle",
                "MERGE 1 2 1 3", "MERGE 1 3 1 4", "UPDATE korean hansik",
                "UPDATE 1 3 group", "UNMERGE 1 4", "PRINT 1 3", "PRINT 1 4"}),
                new String[]{"EMPTY", "group"});
        check(2, s.solution(new String[]{
                "UPDATE 1 1 a", "UPDATE 1 2 b", "UPDATE 2 1 c",
                "UPDATE 2 2 d", "MERGE 1 1 1 2", "MERGE 2 2 2 1",
                "MERGE 2 1 1 1", "PRINT 1 1", "UNMERGE 2 2", "PRINT 1 1"}),
                new String[]{"d", "EMPTY"});
    }

    private static void check(int no, String[] actual, String[] expected) {
        System.out.printf("예 #%d  [%s]  기대값=%s  내결과=%s%n",
                no, Arrays.equals(actual, expected) ? "PASS" : "FAIL",
                Arrays.toString(expected), Arrays.toString(actual));
    }
}
