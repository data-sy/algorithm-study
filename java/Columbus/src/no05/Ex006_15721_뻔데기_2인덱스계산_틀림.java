package no05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Ex006_15721_뻔데기_2인덱스계산_틀림 {

    public static void main(String[] args) throws IOException {
        // https://www.acmicpc.net/problem/25721

        // 2. 재귀 없이
            // 한 바퀴의 크기가 8, 10, 12 이렇게 커져
            // 그리고 그 안에 한 word는 4, 5, 6, 7 이렇게 가지고 있어
            // 이들을 누적합한 4, 9, 15, 22 ~~ 애서 T가 어디에 위치해있는지 찾고
            // 해당 i가 i번 반복하는 구간이야
            // i-1의 값(=i-1까지의 누적합)을 T에서 빼고 나면
            // 그 바퀴에서의 T의 위치 찾을 수 있고
            // 그 인덱스를 A로 나누면 순회해서 해당 위치 찾을 수 있음
        // 2프로에서 틀림 ㅜㅠ
            // 인덱스 처리에서 잘못된 곳이 있었음!

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int A = Integer.parseInt(br.readLine());
        int T = Integer.parseInt(br.readLine());
        int word = Integer.parseInt(br.readLine());

        ArrayList<Integer> list = new ArrayList<>();
        int sum = 4;
        int num = 4;
        while (sum<T){
            list.add(sum);
            sum += ++num;
        }
        // 마지막 누적
        int last = 0;
        if (list.size()>0) last = list.get(list.size()-1);
        int index = T-last-1;

        // word에 따라 인덱스 주기
        if (word==0){
            if (index==0 || index==1) index=2*index+1;
            else index +=2;
        } else {
            if (index==0 || index==1) index=2*index+2;
            else index +=(list.size()+4);
        }
        index +=2*last;

        System.out.println((index-1)%A);

    }

}
