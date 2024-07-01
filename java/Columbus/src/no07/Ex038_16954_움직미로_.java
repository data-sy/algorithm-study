//package no07;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayDeque;
//import java.util.HashSet;
//
//public class Ex038_16954_움직미로_ {
//    static boolean[][] map;
//    static HashSet<Integer> wallSet;
//    static boolean[][] visited;
//    static int[] dy = {0, -1, 1, 0, 0, -1, -1, 1, 1};
//    static int[] dx = {0, 0, 0, -1, 1, 1, -1, -1, 1};
//
//    public static void main(String[] args) throws IOException {
//        // https://www.acmicpc.net/problem/16954
//
//        // 90도로 돌려서 생각하면
//        // (0,0) -> (7, 7)
//
//        // contains를 사용하기 위해 z로 이동
//        // 근데 결국 x값이 0보다 작아지면 (y-1이 되는 게 아니라) 사라져야 하므로 y, x 살려서 담겨있어야 해
//        // 시간 2초 주어져 있으니 시간 복잡도 높은 contains 사용 ok
//
//        // 욱제의
//        // 벽의 x값이 -1이 됨
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        // 길 : true, 벽 : false
//        map = new boolean[8][8];
//        for (int y=0; y<8; y++) {
//            String str = br.readLine();
//            for (int x=0; x<8; x++) {
//                if (str.charAt(x)=='.') map[x][7-y]=true;
//                else wallSet.add(y*8+x);
//            }
//        }
//
////        // 잘 들어갔는지 확인
////        for (int y=0; y<8; y++) {
////            for (int x=0; x<8; x++) {
////                if (map[y][x]) System.out.print(".");
////                else System.out.print("#");
////            }
////            System.out.println();
////        }
//
//        visited = new boolean[8][8];
//        System.out.println(bfs(0, 0));
//
//    }
//    static int bfs(int y, int x) {
//        ArrayDeque<Node> q = new ArrayDeque<>();
//        q.add(new Node(y, x, 0));
//        visited[y][x]=true;
//
//        while(!q.isEmpty()) {
//            Node now = q.poll();
//            y = now.y;
//            x = now.x;
//            int step = now.step;
//
//            // 만약 now가 벽이면 더 이상 이동 불가 => 컨티뉴
//            if (wallSet.contains(now.z+step)) continue;
//
//            //
//            for (int d=0; d<9; d++) {
//                int ny = y + dy[d];
//                int nx = x + dx[d];
//                if ( ny<0 || nx<0 || ny>9 || nx>9 || visited[ny][nx] || !map[ny][nx]) continue;
//                q.add(ny*8+nx);
//                visited[ny][nx]=true;
//            }
//
//            // 벽을 이동
//            for (int wall : wallSet) {
//                map[wall/8][wall%8]=false;
//                map[wall/8][wall%8]=true;
//            }
//
//        }
//        return 0;
//    }
//    static class Node {
//        int y;
//        int x;
//        int step;
//        Node (int , int step) {
//            this.y = y;
//            this.x = x;
//            this.step = step;
//        }
//    }
//}
