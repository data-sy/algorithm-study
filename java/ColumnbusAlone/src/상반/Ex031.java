package 상반;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex031 {

    public static void main(String[] args) throws IOException {
        // https://www.acmicpc.net/problem/2960

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        boolean[] isCompositeArr = new boolean[N+1]; // 합성수면 T, 소수이면 F
        int num = 0;
        boolean isFind = false;
        for (int i = 2; i <= N; i++) {
            if (!isCompositeArr[i]) {
                K--;
                if (K == 0) {
                    num = i;
                    break;
                }
                for (int j = 2 * i; j <= N; j += i) {
                    if (!isCompositeArr[j]) {
                        isCompositeArr[j] = true;
                        K--;
                    }
                    if (K == 0) {
                        num = j;
                        isFind = true;
                        break;
                    }
                }
                if (isFind) break;
            }
        }
        System.out.println(num);

    }

}
