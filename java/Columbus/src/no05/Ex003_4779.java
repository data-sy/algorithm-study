package no05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Ex003_4779 {

    static char[] chars;

    public static void main(String[] args) throws IOException {
        // https://www.acmicpc.net/problem/4779

        // 3^0*{0, 2} + 3^1*{0, 2} + ... + 3^(n-2)*{0, 2} + 3^(n-1)*{0, 2}
        // 여기 위치들은 '-'를 붙이고 나머지는 ' '

        // 반복문 시도하려 했는데 반복문을 N차로 돌려야 해. 정해진 크기라고 해도 시간복잡도 너무 커지고, 크기가 정해지지 않아서 쓰기 어려워 => 그래서 재귀!!

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String line;
        while ( (line=br.readLine()) !=null ){
            int N = Integer.parseInt(line);
            int len = (int) Math.pow(3, N);
            chars = new char[len];
            cantor(N, 0, 0);
            cantor(N, 0, 2);
            for (int i=0; i<len; i++){
                char ch = chars[i];
                if (ch=='-') sb.append(ch);
                else sb.append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    // 맨 마지막 초기화가 0, 2 리턴이 두 가지라서 어떻게 처리할 지 모르겠어서 우선 이렇게 함
    static void cantor(int N, int index, int n) { // n은 0 또는 2
        if (N<0) return;
        int mul =  (int) Math.pow(3, N-1);
        chars[index + mul*n] =  '-';
        cantor(N-1, index + mul*n, 0);
        cantor(N-1, index + mul*n, 2);
    }

}
