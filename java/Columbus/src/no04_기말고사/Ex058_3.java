package no04_기말고사;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex058_3 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        // k진법
        while(n!=0){
            sb.append(n%k);
            n /= k;
        }

        String str = sb.reverse().toString();
        String[] spl = str.split("0");

        int cnt = 0;
        for (int i=0; i<spl.length; i++){
            String check = spl[i];
            if (check.length()>0){
                long N = Long.parseLong(check);
                boolean isPrime = true;
                if (N<2) isPrime = false;
                for (long j=2; j*j<N+1; j++){
                    if (N%j==0){
                        isPrime = false;
                    }
                }
                if (isPrime) cnt++;
            };
        }
        System.out.println(cnt);
    }

}
