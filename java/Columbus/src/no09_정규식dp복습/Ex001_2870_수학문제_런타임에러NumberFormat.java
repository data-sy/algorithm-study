package no09_정규식dp복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Ex001_2870_수학문제_런타임에러NumberFormat {

    public static void main(String[] args) throws IOException {
        // https://www.acmicpc.net/problem/2870

        // 지금 코드대로 하면 ""인 경우가 생겨 - why?
        // 우선은 예외처리 해서 넘기자

        // 1 ≤ N ≤ 100 라서 길이 100자리의 수일 수 있음 => 숫자 자료형 x

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        ArrayList<Integer> list = new ArrayList<>();
        for (int i=0; i<N; i++) {
            String[] strArr = br.readLine().split("[a-z]+");
//            System.out.println("길이 :" + strArr.length);
            for (String str : strArr) {
                if (!str.equals("")) list.add(Integer.parseInt(str));
//                System.out.print(Integer.parseInt(str) + " ");
//                System.out.print(str + ", ");
            }
        }
        Collections.sort(list);

        StringBuilder sb = new StringBuilder();
        list.forEach( e -> sb.append(e).append('\n'));

        System.out.println(sb);
    }

}
