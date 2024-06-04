package no04_복습스터디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Ex012_2141_x {
	
	public static void main(String[] args) throws IOException  {

		// 기존 풀이에서 인덱스만 번호랑 맞춘건데 왜 틀리지????

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;

		long[][] XA = new long[N+1][2];
		for (int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			XA[i][0] = Long.parseLong(st.nextToken());
			XA[i][1] = Long.parseLong(st.nextToken());
		}
		Arrays.sort(XA, Comparator.comparingLong(a -> a[0]));

		long[] sumArr = new long[N+1];
		for (int i=1; i<=N; i++){
			sumArr[i] = sumArr[i-1] + XA[i][1];
		}
//		System.out.println(Arrays.toString(sumArr));

		long target = (sumArr[N]+1)/2;

		// 이진 탐색으로 만든다면 => 시도했는데 실패 ㅜㅠ 3%에서 틀림
		// mid<=target<mid+1 인지 확인
			// 이 때 mid==target이면 mid 선택
			// 아니면 (< <) mid+1 선택
		// mid+1<=target이면
			// l을 mid+1
		// target<mid이면
			// r을 mid-1
//		int mid = N/2;
//		for (int l=0, r=N; l<=r;){
//			mid = (l+r)/2;
//			long lSum = sumArr[mid];
//			long rSum = sumArr[mid+1];
//			if (lSum==target) break;
//			else if (lSum<target && target<rSum){
//				mid++;
//				break;
//			} else if (rSum<=target) l=mid+1;
//			else r=mid-1;
//		}
//		System.out.println(XA[mid][0]);

		// 우선 기존 방식으로 해보자
		int i = 1;
		while(sumArr[i]<target) i++;
		System.out.println(XA[i][0]);
	}

}
