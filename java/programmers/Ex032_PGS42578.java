// 백준: https://www.acmicpc.net/problem/9375
// 프로그래머스: https://school.programmers.co.kr/learn/courses/30/lessons/42578

class Ex032_PGS42578 {

    public int solution(String[][] clothes) {
        int answer = 0;
        return answer;
    }

    public static void main(String[] args) {
        Ex032_PGS42578 sol = new Ex032_PGS42578();

        System.out.println(sol.solution(new String[][]{{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}})); // expected: 5
        System.out.println(sol.solution(new String[][]{{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}})); // expected: 3
    }

}
