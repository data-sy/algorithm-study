package no06;

import java.io.IOException;

public class Ex018_1012_배추_시도한아이디어들 {

    public static void main(String[] args) throws IOException {
        // https://www.acmicpc.net/problem/1012

        // 배추를 Node 클래스 만들어서 관리 => equals 메서드 오버라이딩 해야 해서, 우선은 int[2]로 사용

        // K개 입력값을 set에 담고 contains 사용해서 상하좌우 있는지 확인 => int[2]든 Node든 new로 생성한 것이라 서로 다른 인스턴스 => contains로 판별 불가

        // contains 사용해서 상하좌우가 K에 있는지 점검하기 위해 => 셋, 맵 사용 (시간복잡도 O(1))
        // 입력값 K를 set<int[]>에 담아서 사용하자
        // K개에 대해 adjList, visited 운영
        // set에서 하나씩 빼면서 상하좌우 중 K에 있는 것들을 adjList에 담기 (단방향 운영도 괜찮나? 어차피 해당의 상하좌우 다 넣으니까 괜찮을 듯!)
        // 큐 돌면서 visited 할 건데
        // 불리언 배열이 아니라 해당 스타트 노드의 인덱스를 담기 (약간 부모 노드로 관리하는 것 처럼)
        // visited에 반복문 돌려서 0 제외한 것들 result set에 담기 => set의 사이즈가 결과
        // 안 돼 => int[]는 contains로 못 찾나봐. new로 생성한 객체라서!!!!!!!!!!!!!!

        // 배추 번호 <-> 배추 위치
        // 배열[번호] = 위치 는 시간복잡도 O(N)
        // 개선 => 배열이 아니라 map을 사용해서 키와 밸류를 String 처리하면 사전처럼 찾을 수 있음
        // 안 돼 => String도 레퍼런스 타입이야

        // 결국 처음으로 돌아가서 Node를 만드는 방법으로 해야 할 듯!
        // 이 때, node 안에 index도 같이 넣어버리자

        // 결론
        // 이 문제에서 관건은 "배추 번호 <-> 배추 위치(2차원)" 처리를 어떻게 할 것인지
        // 인접 리스트 돌리려니 더 까다로워져

        // 여기서는 인접리스트 따로 필요 없어. 그냥 dx, dy로 4번 돌리면 되니까!
        // 그려면 그냥 2차원 밭 사용해서 조건 체크하면 돼!!!!

    }


}
