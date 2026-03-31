// 백준: https://www.acmicpc.net/problem/2504
// 프로그래머스: https://school.programmers.co.kr/learn/courses/30/lessons/76502

class Ex028_PGS76502 {

    public int solution(String s) {
        int answer = -1;
        return answer;
    }

    public static void main(String[] args) {
        Ex028_PGS76502 sol = new Ex028_PGS76502();

        System.out.println(sol.solution("[](){}")); // expected: 3
        System.out.println(sol.solution("}]()[{")); // expected: 2
        System.out.println(sol.solution("[)(]")); // expected: 0
        System.out.println(sol.solution("}}}")); // expected: 0
    }

}
