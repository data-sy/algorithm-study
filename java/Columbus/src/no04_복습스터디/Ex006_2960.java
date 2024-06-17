package no04_복습스터디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex006_2960 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int result = -1;
		boolean[] isComposite = new boolean[N+1];
		for(int i=2; i<N+1; i++){
			if(!isComposite[i]) {
				for (int j=i; j<N+1; j+=i){
					if(!isComposite[j]) {
						isComposite[j]=true;
						K--;
					}
					if (K==0) {
						result = j;
						break;
					}
				} if(result>0) break;
			}
		}
		System.out.println(result);
	}
}
