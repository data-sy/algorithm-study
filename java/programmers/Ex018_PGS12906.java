// 백준: https://www.acmicpc.net/problem/1874
// 프로그래머스: https://school.programmers.co.kr/learn/courses/30/lessons/12906

class Ex018_PGS12906 {

    public int[] solution(int []arr) {
        int[] answer = {};
        
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("Hello Java");

        return answer;
    }

    public static void main(String[] args) {
        Ex018_PGS12906 sol = new Ex018_PGS12906();

        System.out.println(sol.solution(new int[]{1,1,3,3,0,1,1})); // expected: [1,3,0,1]
        System.out.println(sol.solution(new int[]{4,4,4,3,3})); // expected: [4,3]
    }

}
