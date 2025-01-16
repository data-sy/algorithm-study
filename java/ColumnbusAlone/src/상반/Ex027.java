package 상반;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Ex027 {

    public static void main(String[] args) throws IOException {
        // https://www.acmicpc.net/problem/2870

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        List<String> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String[] strArr = br.readLine().split("[a-z]");
            for (String str : strArr) {
                if (!str.equals("")) {
                    String tmp = str.replaceAll("^0+","");
                    if (tmp.equals("")) list.add("0");
                    else list.add(tmp);
                }
            }
        }

        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length()) return o1.compareTo(o2);
                else return Integer.compare(o1.length(), o2.length());
            }
        });

        list.forEach(e -> sb.append(e).append('\n'));
        System.out.println(sb);

    }

}
