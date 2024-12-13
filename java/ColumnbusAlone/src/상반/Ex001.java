package 상반;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex001 {
    public static void main(String[] args) throws IOException {
        // https://www.acmicpc.net/problem/11720
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();

        int sum = 0;
        for (int i=0; i<str.length(); i++){
            sum+= Character.getNumericValue(str.charAt(i));
        }

        System.out.println(sum);

    }
}
