package src.set01;

import java.util.*;

public class Ex005_181916 {

    // 문제: 주사위 게임 3
    // https://school.programmers.co.kr/learn/courses/30/lessons/181916
    // 키워드: 조건 분기 - 네 주사위 눈의 중복 패턴별 점수 계산
    // 레벨: Lv.0 (코딩 기초 트레이닝)
    //
    // 제한사항
    // - a, b, c, d는 1 이상 6 이하의 정수
    //
    // 점수 규칙
    // - 네 개 모두 p        : 1111 * p
    // - 세 개 p, 나머지 q   : (10 * p + q)^2
    // - 두 개씩 p, q        : (p + q) * |p - q|
    // - 두 개 p, 나머지 q,r : q * r
    // - 모두 다름           : 가장 작은 숫자

    public int solution(int a, int b, int c, int d) {
        int answer = 0;

        int[] numArr = new int[]{a, b, c, d};
        int[] sorted = new int[]{a, b, c, d};
        int cntSame = 0;
        for (int i=0; i<4; i++) {
            int min = sorted[i];
            int minIndex = i;
            for (int j=i+1; j<4; j++) {
                if (min>sorted[j]) {
                    min = sorted[j];
                    minIndex = j;
                }
                if (numArr[i]==numArr[j]) cntSame++;
            }
            sorted[minIndex] = sorted[i];
            sorted[i] = min;
        }

        // 오름차순으로 재나열 한 것을 e<=f<=g<=h라고 했을 때
        // cntSame은 (e, f), (e, g), (e, h), (f, g), (f, h), (g, h) 모든 조합들 중 1원소와 2원소 값이 같은 경우의 수
        // 4개 모두 같은 경우(cntSame=6): e=f=g=h
        // 3개만 같은 경우(cntSame=3): e<f=g=h 또는 e=f=g<h
        // 2개, 2개 같은 경우(cntSame=2): e=f<g=h
        // 2개만 같은 경우(cntSame=1): e=f<g<h 또는 e<f=g<h 또는 e<f<g=h
        // 모두 다른 경우(cntSame=0): e<f<g<h
        int e = sorted[0];
        int f = sorted[1];
        int g = sorted[2];
        int h = sorted[3];
        if (cntSame==6) answer = 1111*e;
        else if (cntSame==3) {
            if (e==f) answer = (int) Math.pow(10*e+h, 2);
            else answer = (int) Math.pow(10*h+e, 2);
        } else if (cntSame==2) {
            answer = (e+h)*(h-e);
        } else if (cntSame==0) {
            answer = e;
        } else if (f==g) { //cntSame==1인 경우만 남음
            answer = e*h;
        } else if (e==f) {
            answer = g*h;
        } else answer = e*f;

        return answer;
    }

    // 느낀 점 — 다른 풀이
    // 정렬됐으므로 e=h이면 e=f=g=h -> cntSame 없이 조건문 만들 수 있음
    //   if (e==h)      { return 4개 모두 같은 경우 }
    //   else if (f==g) { // e!=h가 전제됨
    //       if (e==f||g==h) { return 3개가 같은 경우 }
    //       else            { return 2개만 같은 경우 } // e<f=g<h
    //   }
    //   else if (e==f) { // e!=h, f!=g가 전제됨
    //       if (g==h) { return 2개, 2개 같은 경우 }
    //       else      { return 2개만 같은 경우 }     // e=f<g<h
    //   }
    //   else if (g==h) { return 2개만 같은 경우 }     // e<f<g=h
    //   else           { return 모두 다른 경우 }
    //
    // Q. 중복조합으로 풀어낼 순 없었을까?
    // A. 경우의 수를 세는 게 아니라 실제 값을 이용해 계산해야 하므로 안될 듯?

    // ===== 아래는 채점용. 풀이만 위에서 수정하면 됩니다 =====

    public static void main(String[] args) {
        Ex005_181916 s = new Ex005_181916();

        check(1, s.solution(2, 2, 2, 2), 2222);
        check(2, s.solution(4, 1, 4, 4), 1681);
        check(3, s.solution(6, 3, 3, 6), 27);
        check(4, s.solution(2, 5, 2, 6), 30);
        check(5, s.solution(6, 4, 2, 5), 2);
    }

    private static void check(int no, int actual, int expected) {
        System.out.printf("예 #%d  [%s]  기대값=%d  내결과=%d%n",
                no, actual == expected ? "PASS" : "FAIL", expected, actual);
    }
}
