// 백준: https://www.acmicpc.net/problem/10816
// 프로그래머스: https://school.programmers.co.kr/learn/courses/30/lessons/42576

class Ex031_PGS42576 {

    public String solution(String[] participant, String[] completion) {
        String answer = "";
        return answer;
    }

    public static void main(String[] args) {
        Ex031_PGS42576 sol = new Ex031_PGS42576();

        System.out.println(sol.solution(new String[]{"leo", "kiki", "eden"}, new String[]{"eden", "kiki"})); // expected: "leo"
        System.out.println(sol.solution(new String[]{"marina", "josipa", "nikola", "vinko", "filipa"}, new String[]{"josipa", "filipa", "marina", "nikola"})); // expected: "vinko"
        System.out.println(sol.solution(new String[]{"mislav", "stanko", "mislav", "ana"}, new String[]{"stanko", "ana", "mislav"})); // expected: "mislav"
    }

}
