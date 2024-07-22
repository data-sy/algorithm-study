package no10_재귀브루트포싱;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex016_4779_칸토어_재귀 {
    static boolean[] arr;

    public static void main(String[] args) throws IOException {
        // https://www.acmicpc.net/problem/4779

        // 3^0*{0, 2} + 3^1*{0, 2} + ... + 3^(n-2)*{0, 2} + 3^(n-1)*{0, 2}

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String line;
        while ((line = br.readLine())!=null) {
            int N = Integer.parseInt(line);
            arr = new boolean[(int) Math.pow(3, N)];
            cantor(N, 0, 0);
            cantor(N, 0, 2);
            for (int i=0; i<arr.length; i++) {
                if (arr[i]) sb.append('-');
                else sb.append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
    static void cantor(int pow, int index, int n) {
        if (pow<0) return;

        int mul = (int) Math.pow(3, pow - 1);
        index += mul*n;
        arr[index] = true;

        cantor(pow-1, index, 0);
        cantor(pow-1, index, 2);
    }

}
