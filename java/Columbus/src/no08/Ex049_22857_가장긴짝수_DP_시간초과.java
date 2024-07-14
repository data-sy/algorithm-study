package no08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex049_22857_가장긴짝수_DP_시간초과 {

    public static void main(String[] args) throws IOException {
        // https://www.acmicpc.net/problem/22857

        // 해법 떠올리지 못해서 아이디어 찾아 봄
        // 아이디어 : 투포인터 L과 R 사이의 홀수의 개수 세기. K보다 크면 L 증가, 작으면 R 증가

        // l, r을 짝수로 관리하면 안 돼
        // 8 2
        // 2 2 2 2 1 1 1 1
        // 꼭 짝수 내부에서 홀수를 삭제하는 건 아니야

        // 7%에서 런타임 에러 (ArrayIndexOutOfBounds)
            // l++, r++를 할 때는 인덱스를 넘어가면 안 돼!

        // 90%에서 시간초과

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // 수열의 길이가 1일 때
        if (N==1) {
            System.out.println(0);
        } else { // 2 이상일 때
            int[] arr = new int[N];
            int[] memo = new int[N]; // 홀수의 개수를 미리 세어두기
            st = new StringTokenizer(br.readLine());
            arr[0] = Integer.parseInt(st.nextToken());
            if (arr[0]%2==1) memo[0]=1;
            for (int i=1; i<N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                if (arr[i]%2==1) memo[i]=memo[i-1]+1;
                else memo[i]=memo[i-1];
            }

            int max = 0;
            for (int l=0, r=1; l<N;) {
                int tmp = memo[r] - memo[l]; // l과 r 사이의 홀수 개수
                if (tmp>K) l++;
                else if (tmp<K) {
                     if(r<N-1) r++;
                }
                else {
                    if (arr[l]%2==0) max = Math.max(max, r-l+1-K);
                    else max = Math.max(max, r-l-K);
//                    System.out.println("max: " + max);
//                    System.out.println(l + ", " + r);
                    if (r<N-1) r++;
                    else break;
                }
            }
            System.out.println(max);
        }

    }

}
