// 백준: https://www.acmicpc.net/problem/11047
// 프로그래머스: https://school.programmers.co.kr/learn/courses/30/lessons/42862

class Ex041_PGS42862 {

    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        return answer;
    }

    public static void main(String[] args) {
        Ex041_PGS42862 sol = new Ex041_PGS42862();

        System.out.println(sol.solution(5, new int[]{2, 4}, new int[]{1, 3, 5})); // expected: 5
        System.out.println(sol.solution(5, new int[]{2, 4}, new int[]{3})); // expected: 4
        System.out.println(sol.solution(3, new int[]{3}, new int[]{1})); // expected: 2
    }

}
