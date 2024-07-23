package no10_재귀브루트포싱;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex018_15721_번데기 {

    public static void main(String[] args) throws IOException {
        // https://www.acmicpc.net/problem/15721

        // 1회차 4개, 2회차 5개, ..., n회차 n+3개 (cnt)
        // T가 몇 회차에 있는지 찾고, 그 회차에서 T의 위치 찾기 (index)
        // 직전 회차까지의 개수 (sum)

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int A = Integer.parseInt(br.readLine());
        int T = Integer.parseInt(br.readLine());
        boolean isBbun = Integer.parseInt(br.readLine()) == 0 ? true : false;

        int cnt=1;
        int sum=4;
        while (sum<T){
            cnt++;
            sum+=cnt+3;
        }
        sum-=cnt+3;
//        System.out.println(sum);
//        System.out.println(cnt);

        // cnt회차 내에서 뻔/데기에 따른 위치
        int index = T - sum;
//        System.out.println("처음" + index);
        if (index>2) {
            if (isBbun) index +=2;
            else index+=cnt+3; // 뻔 2개 + 그 회차에서 뻔의 뒤 개수 cnt+1
        } else {
            if (isBbun) index = index*2-1;
            else index*=2;
        }
//        System.out.println("회차 내부 인덱"+index);

        // 번+데기 모두 포함한 실제 위치로 이동
        sum*=2;
        sum+=index;
//        System.out.println(sum);

        // A명에서 sum번째 찾으면 끝
        int result = (sum-1)%A;
        System.out.println(result);




    }

}
