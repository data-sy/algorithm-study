package no01_카카오기출;

import java.util.ArrayList;
import java.util.Arrays;

public class Ex008_거리두기확인하기_0829 {

	static Character[][] room;
	static ArrayList<int[]> PList;
	static boolean[][] visited;
	static final int[] dx = {0, 0, -1, 1}; // 상, 하, 좌, 우
	static final int[] dy = {-1, 1, 0, 0};
	static boolean keepDistance;

	public static void main(String[] args) {

//		String[][] places = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
//				{"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
//				{"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
//				{"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
//				{"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};

		String[][] places = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
				{"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
				{"PXOPX", "OPOXP", "OXPOX", "OXXOP", "PXPOX"}, // (1, 1)이 P이므로 false
				// keepDistance를 초기화하지 않으면 다음 대기실이 영향 받을 수 있음
				// 3번 대기실에서 keepDistance가 false가 됐는데 4번 대기실에서 P가 없어서 for문 안으로 들어가지 않으면 그대로 false 처리 돼
				{"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
				{"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};

		int[] answer = new int[5];

		for (int t=0; t<5; t++) {
			String[] place = places[t];

			room = new Character[5][5];
			PList = new ArrayList<>();
			int pNum = 1;
			for (int i=0; i<5; i++) {
				String row = place[i];
				for (int j=0; j<5; j++) {
					char tmp = row.charAt(j);
					room[i][j] = tmp;
					if (tmp=='P') PList.add(new int[]{i, j});
				}
			}
//			// 확인
//			for (int i=0; i<5; i++) {
//				for (int j=0; j<5; j++) {
//					System.out.print(room[i][j]);
//				}
//				System.out.println();
//			}
//			System.out.println();
//			PList.forEach(e -> System.out.print(Arrays.toString(e) + ", "));
//			System.out.println();

			visited = new boolean[5][5];
			keepDistance = true; // 거리두기를 초기화 하지 않으면 P가 비어있을 때 영향 받음
			for (int[] index : PList) {
				keepDistance = true;
				dfs(index[0], index[1], 1);
				if (!keepDistance) break;
			}
			if (keepDistance) answer[t]=1;
		}
		System.out.println(Arrays.toString(answer));

	}

	static void dfs (int y, int x, int depth) {
		visited[y][x] = true;

		// depth 3이면 stop
		if (depth==3) return;

		for (int d=0; d<4; d++) {
			int ny = y + dy[d];
			int nx = x + dx[d];
			if ( nx<0 || ny<0 || nx>=5 || ny>=5 || visited[ny][nx] || room[ny][nx]=='X') continue;
			if (room[ny][nx]=='P') {
				keepDistance = false;
				return;
			}
			dfs(ny, nx, depth+1);
		}

	}

}
