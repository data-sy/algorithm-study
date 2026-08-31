// 프로그래머스: https://school.programmers.co.kr/learn/courses/30/lessons/72410

class Ex050_PGS72410 {

    public String solution(String new_id) {
        String answer = "";
        return answer;
    }

    public static void main(String[] args) {
        Ex050_PGS72410 sol = new Ex050_PGS72410();

        System.out.println(sol.solution("...!@BaT#*..y.abcdefghijklm")); // expected: "bat.y.abcdefghi"
        System.out.println(sol.solution("z-+.^."));                      // expected: "z--"
        System.out.println(sol.solution("=.="));                          // expected: "aaa"
        System.out.println(sol.solution("123_.def"));                     // expected: "123_.def"
        System.out.println(sol.solution("abcdefghijklmn.p"));             // expected: "abcdefghijklmn"
    }

}
