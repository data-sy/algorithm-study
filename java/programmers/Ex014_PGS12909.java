// 백준: https://www.acmicpc.net/problem/9012
// 프로그래머스: https://school.programmers.co.kr/learn/courses/30/lessons/12909

class Ex014_PGS12909 {

    boolean solution(String s) {
        boolean answer = true;

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("Hello Java");

        return answer;
    }

    public static void main(String[] args) {
        Ex014_PGS12909 sol = new Ex014_PGS12909();

        System.out.println(sol.solution("()()")); // expected: true
        System.out.println(sol.solution("(())()")); // expected: true
        System.out.println(sol.solution(")()(")); // expected: false
        System.out.println(sol.solution("(()(")); // expected: false
    }

}
