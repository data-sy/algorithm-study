package 상반;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex012 {

    public static void main (String[] args) throws IOException {
        // https://www.acmicpc.net/problem/1373

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String binary = br.readLine();

        binary = "0".repeat((3 - binary.length() % 3) % 3) + binary;

        for (int i = 0; i < binary.length(); i += 3) {
            int n = 4*Character.getNumericValue(binary.charAt(i))
                    + 2*Character.getNumericValue(binary.charAt(i+1))
                    + Character.getNumericValue(binary.charAt(i+2));
            sb.append(n);
        }

        System.out.println(sb);

    }

}
