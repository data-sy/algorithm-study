package 상반;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex055 {

    public static void main(String[] args) throws IOException {
        // https://www.acmicpc.net/problem/1541

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] strArr = br.readLine().split("-");
        int sum = add(strArr[0]);
        for (int i = 1; i < strArr.length; i++) {
            sum -= add(strArr[i]);
        }
        System.out.println(sum);

    }
    static int add(String str) {
        int sum = 0;
        String[] arr = str.split("\\+");
        for (String n : arr) {
            sum += Integer.parseInt(n);
        }
        return sum;
    }
}
