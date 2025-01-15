package 상반;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Ex035 {

    public static void main(String[] args) throws IOException {
        // https://www.acmicpc.net/problem/1620

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();

        String[] nameArr = new String[N+1];
        Map<String, Integer> numMap = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            String str = br.readLine();
            nameArr[i] = str;
            numMap.put(str, i);
        }
        for (int i = 1; i <= M; i++) {
            String str = br.readLine();
            if (65 <= str.charAt(0)) sb.append(numMap.get(str)).append('\n');
            else sb.append(nameArr[Integer.parseInt(str)]).append('\n');
        }
        System.out.println(sb);
    }

}
