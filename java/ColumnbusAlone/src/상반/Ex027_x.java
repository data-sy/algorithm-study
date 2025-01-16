package 상반;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ex027_x {

    public static void main(String[] args) throws IOException {
        // https://www.acmicpc.net/problem/2870

        // 크기가 큰 integer에서는 런타임 에러

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String[] strArr = br.readLine().split("[a-z]");
            for (String str : strArr) {
                if (!str.equals("")) list.add(Integer.parseInt(str));
            }
        }

        Collections.sort(list);

        for (int num : list) {
            sb.append(num).append('\n');
        }
        System.out.println(sb);

    }

}
