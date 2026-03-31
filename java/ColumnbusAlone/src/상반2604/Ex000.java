package 상반2604;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Ex000 {
    public static void main(String[] args) throws IOException {
        // 몸풀기 문제들. 입출력, 배열

        // 1번
        String greeting = "Hello World!";
        System.out.println(greeting);

        // 2번
        // input: 1 2 3
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        int n3 = sc.nextInt();
        System.out.println(n1);
        System.out.println(n2);
        System.out.println(n3);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.close();


    }
}
