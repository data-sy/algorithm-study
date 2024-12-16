package 상반;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex002 {
    public static void main(String[] args) throws IOException {
        // https://www.acmicpc.net/problem/9046

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int[] arr = new int[26];
            String str = br.readLine();
            for (int j = 0; j < str.length(); j++) {
                Character ch = str.charAt(j);
                if (ch==32) continue; // ' '(공백)의 아스키코드 : 32
                arr[ch-97]++;
            }
            int max = 0;
            int maxIndex = 0;
            for (int j = 0; j < arr.length; j++) {
                if (arr[j]>max) {
                    max = arr[j];
                    maxIndex = j;
                }
            }
            // 제일 큰 게 무엇인지 확인 한 다음, 중복 되는 게 있는지 체크해야 해
            // 이 방법보다 더 좋은 방법 있는지 검색해보자.
            // 내가 > 으로 조건문을 달았기 때문에 최초로 나온 최댓갑의 인덱스가 담겨. 즉, 그 인덱스 뒤만 체크해도 돼
            boolean isDuple = false;
            for (int j = maxIndex+1; j < arr.length; j++) {
                if (arr[j]==max) {
                    isDuple = true;
                    break;
                }
            }
            if (isDuple) sb.append('?').append('\n');
            else sb.append((char) (maxIndex + 97)).append('\n');
        }
        System.out.println(sb);

    }
}
