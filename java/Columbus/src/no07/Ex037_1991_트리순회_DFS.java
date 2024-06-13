package no07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Ex037_1991_트리순회_DFS {

    static ArrayList<Integer>[] adjList;
    static boolean[] visited;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        // https://www.acmicpc.net/problem/1991

        // A 아스키코드 65
        // . 아스키코드 46

        // .을 제외하고 넣으면 왼쪽인지 오른쪽인지 구별 불가능
        // 즉, .에 해당하는 값 할당하자. => -1


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        adjList = new ArrayList[N];
        for (int i=0; i<N; i++) {
            adjList[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int root = st.nextToken().charAt(0);
            int left = st.nextToken().charAt(0);
            int right = st.nextToken().charAt(0);
            if (left==46) adjList[root-65].add(-1);
            else adjList[root-65].add(left-65);
            if (right==46) adjList[root-65].add(-1);
            else adjList[root-65].add(right-65);
        }

//        // 잘 들어갔나 확인
//        for (int i=0; i<N; i++) {
//            adjList[i].forEach(e -> System.out.print(e + ", "));
//            System.out.println();
//        }

        sb = new StringBuilder();
        visited = new boolean[N];
        preorder(0);
        sb.append('\n');

        visited = new boolean[N];
        inorder(0);
        sb.append('\n');

        visited = new boolean[N];
        postorder(0);

        System.out.println(sb);

    }
    static void preorder(int i) {
        visited[i] = true;
        sb.append((char) (i + 65));

        for (int next : adjList[i]) {
            if (next>0 && !visited[next]) preorder(next);
        }
    }
    static void inorder(int i) {
        visited[i] = true;
        // 왼쪽 자식이 있다면
        int left = adjList[i].get(0);
        if (left>0 && !visited[left]) inorder(left);
        // 루트
        sb.append((char) (i + 65));
        // 오른쪽 자식이 있다면
        int right = adjList[i].get(1);
        if (right>0 && !visited[right]) inorder(right);
    }
    static void postorder(int i) {
        visited[i] = true;

        for (int next : adjList[i]) {
            if (next>0 && !visited[next]) postorder(next);
        }
        // 인접을 다 털고 root를 담는 것
        sb.append((char) (i + 65));
    }
}
