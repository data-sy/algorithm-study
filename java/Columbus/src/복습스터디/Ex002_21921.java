package 복습스터디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex002_21921 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());

		int[] arrSum = new int[N+1];
		st = new StringTokenizer(br.readLine());
		arrSum[1]=Integer.parseInt(st.nextToken());
		for(int i=2; i<N+1; i++){
			arrSum[i] = arrSum[i-1] + Integer.parseInt(st.nextToken());
		}

		if (arrSum[N]==0) System.out.println("SAD");
		else {
			int max = arrSum[X];
			int cnt = 1;
			for (int i=X+1; i<=N; i++){
				int visit = arrSum[i] - arrSum[i-X];
				if (visit>max) {
					max = visit;
					cnt = 1;
				} else if (visit==max) cnt++;
			}
			System.out.println(max);
			System.out.println(cnt);
		}
	}
}
