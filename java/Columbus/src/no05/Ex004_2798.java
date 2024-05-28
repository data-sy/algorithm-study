package no05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Ex004_2798 {

    public static void main(String[] args) throws IOException {
        // https://www.acmicpc.net/problem/2798

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
//        Arrays.sort(arr);

        int max = 0;
        boolean isM = false;
        for (int i=0; i<N; i++){
//            int check = M - arr[i];
            // check로 나머지 원소들 투포인터 (딱 M이 아니라 최대로 각까운 수인데 투포인터가 그걸 놓치지 않을 수 있을까?)
            // 우선 부르트포싱 문제니까 다 돌리는 걸로 해보자. 투포인터 말고
            for (int j=i+1; j<N; j++){
                for (int k=j+1; k<N; k++){
                    int sum = arr[i]+arr[j]+arr[k];
                    if (sum==M) {
                        isM = true;
                        break;
                    } else if (sum<M && max<sum)   max = sum;
                }
                if (isM) break;
            }
            if (isM) break;
        }

        if (isM) System.out.println(M);
        else System.out.println(max);

    }

}
