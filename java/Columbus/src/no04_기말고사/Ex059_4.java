package no04_기말고사;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Ex059_4 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());


        for (int t=0; t<T; t++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            // 0 ~ 7인 d번 행위 반복하도록
            d = (d/45+8)%8;

            // turn의 중심은 m, m
            // 즉, (i-m, j-m)에다가 회전시킨 후 다시 +m, +m

            // 입력 받기
            int[][] arr = new int[n][n];
            for (int i=0; i<n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j=0; j<n; j++) arr[i][j] = Integer.parseInt(st.nextToken());
            }

            int[][] result = new int[n][n];
            int m = n/2;
            for (int i=0; i<n; i++){
                for (int j=0; j<n; j++) {
                    if ( i==m || j==m || i-j==0 || i+j==n-1) { // 회전 할 조건 안의 애들
                        for (int k=1; k<=m; k++){
                            LinkedList<Integer[]> turnList = turn(k, d);
                            for(Integer[] ijList : turnList) {
                                result[ijList[0]+m][ijList[1]+m] = arr[i][j];
                            }
                        }
                    } else result[i][j] = arr[i][j];
                }
            }
            // sb에 담기
            for (int i = 0; i<n; i++) {
                for (int j=0; j<n; j++) {
                    sb.append(result[i][j]).append(" ");
                }
                sb.append("\n");
            }

            System.out.println(sb);

        }
    }

    static LinkedList<Integer[]> turn(int k, int d) {
        Integer[][] turnArr = {{k, 0}, {k, k}, {0, k}, {-k, k}, {-k, 0}, {-k, -k}, {0, -k}, {k, -k}};
        LinkedList<Integer[]> turnList = new LinkedList<>(Arrays.asList(turnArr));
        while(d>=0){
            turnList.add(turnList.poll());
            d--;
        }
        return turnList;


    }
}
