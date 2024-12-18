package 상반;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex004 {
    public static void main (String[] args) throws IOException {
        // https://www.acmicpc.net/problem/1157

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int[] arr = new int[26];
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (97 <= ch && ch <= 122) arr[ch - 97]++;
            else arr[ch - 65]++;
        }

        int max = 0;
        int firstIndexOfMax = 0;
        // 002에서는 변수명을 maxIndex를 사용했는데 '가장 큰 인덱스'라는 뉘앙스가 풍겨져서 여기서는 수정함
        // 두 번째 for문에서 첫번째 인덱스라는 의미를 활용하므로 first도 붙임 (나중에 코테 바탕으로 면접 볼 때 면접관이 더 잘 이해하실 수 있도록)
        for (int i = 0; i < 26; i++) {
            if (max < arr[i]) {
                max = arr[i];
                firstIndexOfMax = i;
            }
        }

        boolean isDuple = false;
        for (int i = firstIndexOfMax+1; i < 26; i++) {
            if (arr[i] == max) {
                isDuple = true;
                break;
            }
        }

        if (isDuple) System.out.println("?");
        else System.out.println((char) (firstIndexOfMax + 65));

    }
}
