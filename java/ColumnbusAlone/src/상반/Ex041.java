package 상반;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Ex041 {

    public static void main(String[] args) throws IOException {
        // https://www.acmicpc.net/problem/18115

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        String[] arr = new String[N+1];
        for (int i = 0; i < N; i++) {
            arr[i] = st.nextToken();
        }

        List<Integer> list = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            switch (arr[N-i]) {
                case ("1"):
                    list.add(0, i);
                    break;
               case ("2"):
                    list.add(1, i);
                    break;
               case ("3"):
                    list.add(i);
                    break;
            }
        }
        list.forEach(i -> sb.append(i).append(' '));

        System.out.println(sb);

    }

}
