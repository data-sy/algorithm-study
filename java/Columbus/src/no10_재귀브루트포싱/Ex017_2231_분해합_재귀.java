package no10_재귀브루트포싱;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex017_2231_분해합_재귀 {
    static int N;

    public static void main(String[] args) throws IOException {
        // https://www.acmicpc.net/problem/2231

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String strN = br.readLine();

        int powN = strN.length()-1;
        N = Integer.parseInt(strN);

        System.out.println(recur(powN, 0, 0));

    }
    static int recur(int pow, int sum, int num) {
        if (sum==N) return num;
        if (pow<0) return 0;

        for (int i=0; i<10; i++) {
            int tmp = ((int) Math.pow(10, pow))*i;
//            System.out.println(String.format("i=%d, tmp=%d, 최종 sum=%d, 이때의 num=%d", i, tmp, sum+tmp+i, num+tmp));
            int result = recur(pow-1, sum + tmp + i, num + tmp);
            if (result!=0) return result;
        }

        return 0;
    }

}
