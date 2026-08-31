// 백준: https://www.acmicpc.net/problem/18258
// 프로그래머스: https://school.programmers.co.kr/learn/courses/30/lessons/42583

class Ex017_PGS42583 {

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        return answer;
    }

    public static void main(String[] args) {
        Ex017_PGS42583 sol = new Ex017_PGS42583();

        System.out.println(sol.solution(2, 10, new int[]{7,4,5,6})); // expected: 8
        System.out.println(sol.solution(100, 100, new int[]{10})); // expected: 101
        System.out.println(sol.solution(100, 100, new int[]{10,10,10,10,10,10,10,10,10,10})); // expected: 110
    }

}
