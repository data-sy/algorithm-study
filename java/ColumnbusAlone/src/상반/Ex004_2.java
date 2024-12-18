package 상반;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex004_2 {
    public static void main (String[] args) throws IOException {
        // https://www.acmicpc.net/problem/1157

        // 최빈 알파벳을 찾을 때 미리 개수를 count해서 for문 한 개만 사용하는 방법

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int[] arr = new int[26];
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (97 <= ch && ch <= 122) arr[ch - 97]++;
            else arr[ch - 65]++;
        }

        int max = 0;
        int indexOfMax = 0;
        // 앞의 방법에서는 first가 선택됐는데, 이 방법에서는 last가 선택됨
        // 근데 어차피 last라는 의미가 사용되지 않으므로 그냥 index ㄱㄱ
        int countOfMax = 0;
        for (int i = 0; i < 26; i++) {
            if (max <= arr[i]) {
                countOfMax = max == arr[i] ? countOfMax + 1 : 1;
                max = arr[i];
                indexOfMax = i;
            }
        }

        if (countOfMax>1) System.out.println("?");
        else System.out.println((char) (indexOfMax + 65));

    }
}
