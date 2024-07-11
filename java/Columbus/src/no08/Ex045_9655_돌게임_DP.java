package no08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex045_9655_돌게임_DP {

    public static void main(String[] args) throws IOException {
        // https://www.acmicpc.net/problem/9655

        // 홀수이면 상근이, 짝수이면 창영이인 것 같은데... => 맞아
        // 이렇게 풀라고 낸 문제가 아닌 것 같은데...
        // DP적으로 접근하는 건 뭘까?

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        System.out.println(N%2==1? "SK" : "CY");

    }

}
