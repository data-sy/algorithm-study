package 상반;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.SortedMap;
import java.util.TreeMap;

public class Ex010 {

    public static void main (String[] args) throws IOException {
        // https://www.acmicpc.net/problem/20291

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        SortedMap<String, Integer> map = new TreeMap<>();

        for (int i = 0; i < N; i++) {
            String[] strArr = br.readLine().split("\\.");
            String extension = strArr[1];
            map.put(extension, map.getOrDefault(extension, 0) + 1);
        }

        map.forEach((k, v) -> sb.append(k).append(' ').append(v).append('\n'));
        System.out.println(sb);

    }

}
