// 백준: https://www.acmicpc.net/problem/14425
// 프로그래머스: https://school.programmers.co.kr/learn/courses/30/lessons/42577

class Ex036_PGS42577 {

    public boolean solution(String[] phone_book) {
        boolean answer = true;
        return answer;
    }

    public static void main(String[] args) {
        Ex036_PGS42577 sol = new Ex036_PGS42577();

        System.out.println(sol.solution(new String[]{"119", "97674223", "1195524421"})); // expected: false
        System.out.println(sol.solution(new String[]{"123", "456", "789"}));             // expected: true
        System.out.println(sol.solution(new String[]{"12", "123", "1235", "567", "88"})); // expected: false
    }

}
