// 백준: https://www.acmicpc.net/problem/9046

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex002_1_BG9046 {

    public static void main(String[] args) throws IOException {
        // 방법1: 배열 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i <T; i++) {
            String str = br.readLine();
            int[] arr = new int[26];

            for (int j = 0; j < str.length(); j++) {
                int index = str.charAt(j);
                if (index==32) continue; // 공백의 아스키코드 32
                arr[index - 97]++;
            }
            int max = 0;
            StringBuilder result = new StringBuilder();
            for (int j = 0; j < arr.length; j++) {
                if (max > arr[j]) continue;
                if (max < arr[j]) {
                    max = arr[j];
                    result.setLength(0); // 클리어 같은 건 없나?
                    result.append(Character.toChars(j+97));
                } else {
                    result.append(Character.toChars(j+97));
                }
            }
            if (result.length()==1) sb.append(result);
            else sb.append("?");
            sb.append('\n');
        }
        sb.setLength(sb.length()-1);
        System.out.println(sb);
    }

}
