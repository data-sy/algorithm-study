package no06_중간고사;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex029_17478_재귀질문_재귀 {

    static int N;
    static StringBuilder sb;
    static String question;
    static String answer1;
    static String answer2;
    static String answer3;
    static String answer4;

    public static void main(String[] args) throws IOException {
        // https://www.acmicpc.net/problem/17478

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        sb = new StringBuilder();
        sb.append("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.").append('\n');
        question = "\"재귀함수가 뭔가요?\"";
        answer1 = "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.";
        answer2 = "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.";
        answer3 = "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"";
        answer4 = "라고 답변하였지.";

        recur(0);
        System.out.println(sb);

    }
    static void recur (int i) {
        sb.append("____".repeat(i)).append(question).append('\n');

        if (i==N) {
            sb.append("____".repeat(i)).append("\"재귀함수는 자기 자신을 호출하는 함수라네\"").append('\n');
            sb.append("____".repeat(i)).append(answer4).append('\n');
            return;
        }

        sb.append("____".repeat(i)).append(answer1).append('\n');
        sb.append("____".repeat(i)).append(answer2).append('\n');
        sb.append("____".repeat(i)).append(answer3).append('\n');
        recur(i+1);
        sb.append("____".repeat(i)).append(answer4).append('\n');

    }

}
