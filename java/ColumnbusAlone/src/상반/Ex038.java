package 상반;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Ex038 {

    public static void main(String[] args) throws IOException {
        // https://www.acmicpc.net/problem/9375

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            Map<String, Integer> map = new HashMap<>();
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                st.nextToken();
                String str = st.nextToken();
                map.put(str, map.getOrDefault(str, 0) + 1);
            }
            int cnt = 1;
            for (int num : map.values()) {
                cnt *= (num + 1);
            }
            sb.append(cnt - 1).append('\n');
        }

        System.out.println(sb);
    }

}
