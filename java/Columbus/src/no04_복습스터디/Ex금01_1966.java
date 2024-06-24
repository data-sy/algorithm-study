package no04_복습스터디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Ex금01_1966 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;

		for (int i=0; i<T; i++){
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int I = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			LinkedList<int[]> queue = new LinkedList<>();
			for (int j=0; j<N; j++){
				queue.add(new int[]{j,Integer.parseInt(st.nextToken())});
			}
			int cnt = 0;
			while(!queue.isEmpty()) {
				boolean hasNoMax = true;
				int[] check = queue.poll();
				for (int j=0; j<queue.size(); j++)
					if (check[1] < queue.get(j)[1]) {
						queue.add(check);
						hasNoMax = false;
						break;
				}
				if (hasNoMax) {
					cnt++;
					if (check[0]==I) System.out.println(cnt);
				}
			}
		}
	}
}
