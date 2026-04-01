// 백준: https://www.acmicpc.net/problem/11720

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex001_BG11720 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        line = br.readLine();
        String[] arr = line.split("");

        int sum = 0;
        for (int i = 0; i < N ; i++) {
            sum += Integer.parseInt(arr[i]);
        }
        System.out.println(sum);

    }

}
