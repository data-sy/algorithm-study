// 백준: https://www.acmicpc.net/problem/9046

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Ex002_2_BG9046_Map공부후 {

    public static void main(String[] args) throws IOException {
        // 방법2: 컬렉션 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i <T; i++) {
            String str = br.readLine();

            Map<Character, Integer> map = new HashMap<>();
            for (int j = 0; j < str.length(); j++) {
                Character ch = str.charAt(j);
                if (ch=='\n') continue;
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }
            int max = 0;
            Character maxChar = 'a';
            int cnt = 0;
            // 여기는 자료구조 공부한 뒤에 풀어보자
            // map에서 value 최댓값 찾는 방법




        }

    }

}
