package no04;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Ex052_2141_다른분풀이 {
	
	static long x[], a[], lo= (long)1e9, hi= (long)-1e9, mid=0,left, right;
    static int n;
	
	public static void main(String[] args) throws IOException  {
		// https://www.acmicpc.net/problem/2141

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		
		a= new long[n];
        x= new long[n];
        for (int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine());
            x[i] =Long.parseLong(st.nextToken());
            a[i] =Long.parseLong(st.nextToken());
            lo=Math.min(lo,x[i]);
            hi=Math.max(hi,x[i]);
        }

        System.out.println("lo : " + lo);
        System.out.println("hi : " + hi);

        while (lo<=hi) {
            mid= (lo+hi)/2;
            System.out.println("mid : " + mid);
            left= 0; //mid 지점에 세우는 경우 사람~우체국 거리합
            right=0; //mid+1 지점에 세우는 경우 사람~우체국 거리합
            
            for(int i=0;i<n;i++) {
                left+=a[i]*Math.abs(mid-x[i]);
                right+=a[i]*Math.abs((mid+1)-x[i]);
            }
            
            //가능한 게 여러가지인 경우 가장 작은 위치 반환
           if(left<=right)
                hi=mid-1;
            else
                lo=mid+1;
        }
        System.out.println(lo);
		
	}
	// 아! 저 작업이 while이야
	// 약간 이진탐색
		// 중간을 기준으로
		// 왼쪽이 크면 hi를 중간의 왼쪽으로 옮겨서 줄이고
		// 오른쪽이 크면 lo를 중간의 오른쪽으로 옮겨서 키우고 
}
