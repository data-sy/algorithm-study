// 백준: https://www.acmicpc.net/problem/17276
// 프로그래머스: https://school.programmers.co.kr/learn/courses/30/lessons/77485

class Ex053_PGS77485 {

    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = {};
        return answer;
    }

    public static void main(String[] args) {
        Ex053_PGS77485 sol = new Ex053_PGS77485();

        System.out.println(java.util.Arrays.toString(sol.solution(6, 6, new int[][]{{2,2,5,4},{3,3,6,6},{5,1,6,3}}))); // expected: [8, 10, 25]
        System.out.println(java.util.Arrays.toString(sol.solution(3, 3, new int[][]{{1,1,2,2},{1,2,2,3},{2,1,3,2},{2,2,3,3}}))); // expected: [1, 1, 5, 3]
        System.out.println(java.util.Arrays.toString(sol.solution(100, 97, new int[][]{{1,1,100,97}}))); // expected: [1]
    }

}
