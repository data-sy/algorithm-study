package no04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Ex053_13305_빅인티저 {

	public static void main(String[] args) throws IOException {
		// https://www.acmicpc.net/problem/13305

		// int로 만들면 부분 성공
		// 1<=제일 왼쪽부터 제일 오른쪽 도시 까지의 거리<=1,000,000,000
		// 1<=리터당 가격<= 1,000,000,000
		// 즉, 최악의 경우 거리*리터 => 10^18
//		2
//		100000000
//		100000000 100000000
		// int나 long으로 담으면 1874919424가 나와
		// 각각 빅인트로 바꿔주고 연산하면 10000000000000000 제대로 나와

		// 아냐 처음부터 long[] 사용하면 빅인트까지 안 가도 돼!

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] dArr = new int[N-1];
		for (int i=0; i<N-1; i++) {
			dArr[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		int[] costArr = new int[N];
		for (int i=0; i<N-1; i++) {
			costArr[i] = Integer.parseInt(st.nextToken());
		}
		// 마지막 도시 가격은 필요 없고 대신 비교에서 배제하기 위해 입력값보다 작은 수 담기
		costArr[N - 1] = -1;

		BigInteger costSum = new BigInteger("0");
		for (int i=0; i<N-1; i++) {
			int cost = costArr[i];
			int d = dArr[i];
			while(cost <= costArr[i+1]) {
				d += dArr[i + 1];
				i++;
			}
			// 이 때, cost*d 연산 결과가 크기를 넘어서는 것 이므로 각각을 빅인트로 형변환 한 후 곱해줘야 함
			BigInteger tmp = BigInteger.valueOf(cost).multiply(BigInteger.valueOf(d));
			// 이 때, add연산자가 costSum을 바꾸는 게 아니라 행위만 하는 거라서 다시 costSum에 넣어줘야 해
			costSum = costSum.add(tmp);
			// int, long 사용했을 때
//			costSum += BigInteger.valueOf(cost * d);
		}
		System.out.println(costSum);
	}

	// 입력값 넣을 때
		// st를 하나로 쓰지 않고 각각 새 객체를 생성해서 여려 열을 변수에 담아두고
		// for문 한꺼번에 돌려도 돼

	// while 대신 그냥 if 조건으로 점검해도 돼
}