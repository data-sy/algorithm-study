package no04_복습스터디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Ex003_2531_시간초과 {

	// 시간 초과 풀이

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		String c = st.nextToken();

		LinkedList<String> list = new LinkedList<>();
		// 초기화
		for (int i=0; i<k; i++) {
			list.add(br.readLine());
		}
		HashSet<String> set = new HashSet<>(list);
		int cnt = set.size();
		// List.copyOf는 List에 밖에 못 써서
		LinkedList<String> copyList = new LinkedList<>();
		copyList.addAll(list);

		// 갱신
		Boolean isNotDuAndNotC = false;
		for (int i=k+1; i<=N; i++) {
			list.poll();
			list.add(br.readLine());
			set = new HashSet<>(list);
			int cur = set.size();
			if (!set.contains(c)) {
				cur++;
				if (cur==k+1) {
					isNotDuAndNotC = true;
					break;
				}
			}
			if (cnt<cur) cnt=cur;
		}

		// 회전이라 N ~ N+k-1까지도 점검 해야 해
		if (isNotDuAndNotC==false){
			for (int i=N; i<N+k-1; i++) {
				list.poll();
				list.add(copyList.poll());
				set = new HashSet<>(list);
				int cur = set.size();
				if (!set.contains(c)) {
					cur++;
					if (cur == k + 1) {
						isNotDuAndNotC = true;
						break;
					}
				}
				if (cnt < cur) cnt = cur;
			}
		}

		if (isNotDuAndNotC) System.out.println(k+1); // 중복x이면서 쿠폰도 없는 경우
		else System.out.println(cnt);

	}

}
