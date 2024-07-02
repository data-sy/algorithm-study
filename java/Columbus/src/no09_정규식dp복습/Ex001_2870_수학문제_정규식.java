package no09_정규식dp복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class Ex001_2870_수학문제_정규식 {

    public static void main(String[] args) throws IOException {
        // https://www.acmicpc.net/problem/2870

        // 지금 코드대로 하면 ""인 경우가 생겨 - why?
        // 우선은 예외처리 해서 넘기자

        // 1 ≤ N ≤ 100 라서 길이 100자리의 수일 수 있음 =>  숫자 자료형 x => String
        // 그러면 크기비교는?
        // 만약 그냥 sort하면 1234 보다 34 가 더 커 (처음 인덱스인 1과 3을 비교하므로)
        // 따라서 길이가 다르면 길이가 긴 쪽 / 같으면 그제서야 사전식 비교

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        LinkedList<String> list = new LinkedList<>();
        for (int i=0; i<N; i++) {
            String[] strArr = br.readLine().split("[a-z]+");
            for (String str : strArr) {
                if (!str.equals("")) {
                    // 따로 변수에 담아서 넣지 않으면 의도대로 안 들어가 - why?
                    String tmp = str.replaceAll("^0+", "");
                    // "0"으로만 이루어진 것은 ""이 됨
                    if (tmp.equals("")) list.add("0");
                    else list.add(tmp);
                }
            }
        }

        Collections.sort(list, new StrComparator());

        StringBuilder sb = new StringBuilder();
        list.forEach( e -> sb.append(e).append('\n'));

        System.out.println(sb);

    }

    static class StrComparator implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            if (o1.length()==o2.length()) return o1.compareTo(o2);
            else return Integer.compare(o1.length(), o2.length());
        }

    }

}
