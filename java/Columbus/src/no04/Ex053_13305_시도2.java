package no04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex053_13305_시도2 {

	// 안 풀렸던 이유가 있어!!!! 문제를 잘못 파악하고 계속 고민했어쓰 ㅜㅠㅜㅠㅜㅠㅜㅠㅜ
	// (5)---2---(2)---3---(4)---1---(1)
	// 여기서 5, 2, 4, 1이 살 수 있는 양이라고 생각
	// 그래서 만약 5에서 한 번 사면 2---3을 갈 수 있다고 생각...
	// 근데 그게 아니라, 1리터를 5원에 사는거라서 2 가려면 우선 최소한 5*2=10은 넣어야 해

	static int N;
	static int[] dArr;
	static int[] costArr;
	static int costSum;
	// 그러면 min의 초기값은? => 거리 입력값의 최대
	static int min = 1000000000;


	public static void main(String[] args) throws IOException  {
		// https://www.acmicpc.net/problem/13305

		// 최대한 나누어 떨어지는 만큼까지 구입한 후
		// 기름 0 될 때까지 쉬지 않고 달려
		// 나누어 떨어지는 경우가 안 나오면??? 결국 모든 경우의 수 탐색해야 하나?
		// 그러면 for 안의 for 최대 n-1개.. => 개수가 정해지지 않았으니 재귀로 돌리자

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		dArr = new int[N-1];
		int D = 0;
		for (int i=0; i<N-1; i++) {
			dArr[i] = Integer.parseInt(st.nextToken());
			D += dArr[i];
		}
		st = new StringTokenizer(br.readLine());
		costArr = new int[N-1]; // 마지막 도시 가격은 필요 없어서
		for (int i=0; i<N-1; i++) {
			costArr[i] = Integer.parseInt(st.nextToken());
		}
//		System.out.println(Arrays.toString(costArr));

		System.out.println("처음 D :" +D);
		recursion(0, D, 0);

		System.out.println(min);

	}
	// i에 대해 그것의 costArr[i]의 배수를 for문 돌리면서 costSum이 D보다 작을 때까지 돌리고
	// 그 안에서 또 재귀로 그 다음 코스트 값에 대해 같은 걸 반복
	static void recursion(int i, int d, int preR) { // 맨 처음에 d에 D가 들어오면 돼
		int cost = costArr[i];
		System.out.println("========recursion 들어온 새 cost ====> " + cost);
		// 재귀를 다 돌고 나면 한 경우의 수의 최종 비용
		// 여기서 최소값 갱신
		if (i==N || d<=0) {
			System.out.println("최종적으로 i : " + i);
			System.out.println("최종적으로 d : " + d);
			System.out.println("최종 경우의 수 : " + costSum);
			if (costSum<=min) min = costSum;
			return;
		}

		// 반복 - costArr[i]의 배수가 전체 거리보다 커지기 전까지 모두 시도하는 거니까
		// 이전 바퀴에서 가진 costSum과 이번 바퀴에서 생긴 k*cost를 더해서 전체 길이보다 작으면 돼
		// 아냐! 새로운 재귀는 D와 r을 갱신한 상태야. 현재 입장에서만 보면 돼
		for (int k=0; (k-1)*cost<d; k++) {
			System.out.println("재귀 들어옴 k의 값은? :"+k);
			int r = k*cost - dArr[i]+preR;
			System.out.println("판단할 r의 값은? :"+r);
			if (r<0) {
				System.out.println("넘어가");
				continue; // d만큼 채워지지 않았을 때는 못 가 k를 하나 더 늘려야 해
			}
			// 이 때의 costSum이 한 경우의 수를 의미
			// 여기서 costSum 갱신
			costSum += k*cost;
			System.out.println("costSum : " + costSum);
			System.out.println("i+1: " + (i+1));
			System.out.println("현재 d: " + d);
			System.out.println("다음에 갈 길이: " + dArr[i+1]);
			System.out.println("다음 재귀로 갈 r의 값은? :"+r);
			System.out.println("다음 재귀로 갈 d: " + (d-dArr[i+1]-r));
			recursion(i+1, d-dArr[i+1]-r, r); // 그냥 거리만 뺀게 아니라, 남은 기름만큼도 빼 줘야 해
			// 사용한 값은 다시 빼주기 (이전 마을로 다시 되돌아 가서 점검하니까)
			costSum -= k*cost;
		}
	}
	
}
