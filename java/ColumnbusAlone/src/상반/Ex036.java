package 상반;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class Ex036 {
    static double cnt;

    public static void main(String[] args) throws IOException {
        // https://www.acmicpc.net/problem/4358

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Map<String, Integer> treeMap = new TreeMap<>();
        String str;
        while ((str = br.readLine()) != null) {
            treeMap.put(str, treeMap.getOrDefault(str, 0) + 1);
            cnt++;
        }

        treeMap.forEach( (k, v) -> sb.append(k).append(' ').append(String.format("%.4f",v/cnt*100)).append('\n'));

        System.out.println(sb);
    }

}
