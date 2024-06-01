package no05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex005_2231_분해합_재귀 {

    public static void main(String[] args) throws IOException {
        // https://www.acmicpc.net/problem/2231

        // 이 전 문제는 3개를 선택하는 거라 개수가 고정됐으니 3중 for문 쓰면 됐는데,
        // 이 문제는 길이가 고정되지 않았어 => 재귀

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String strN = Integer.toString(N);
        int powN = strN.length()-1;
        int result = recur(N, 0, powN, 0);
        System.out.println(result);
    }
    static int recur(int N, int sum, int pow, int num){
        if (sum==N) return num;
        if (pow<0) return 0;

        for (int i=0; i<10; i++){
            int tmp = ((int) Math.pow(10, pow))*i;
//            System.out.println(String.format("반복문 안에서 의 (i=%d, tmp=%d, 최종 sum=%d, 이때의 num=%d)", i, tmp, sum+tmp+i, num+tmp));
            int result = recur(N, sum+tmp+i, pow-1, num+tmp);
            if (result !=0 ) return result;
        }

        return 0;
    }

}
