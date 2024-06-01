package no05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex004_2798_3개합_다중포문 {

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
