// 백준: https://www.acmicpc.net/problem/2531
// 프로그래머스: https://school.programmers.co.kr/learn/courses/30/lessons/131127

class Ex040_PGS131127 {

    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        return answer;
    }

    public static void main(String[] args) {
        Ex040_PGS131127 sol = new Ex040_PGS131127();

        System.out.println(sol.solution(new String[]{"banana", "apple", "rice", "pork", "pot"}, new int[]{3, 2, 2, 2, 1}, new String[]{"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"})); // expected: 3
        System.out.println(sol.solution(new String[]{"apple"}, new int[]{10}, new String[]{"banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana"})); // expected: 0
    }

}
