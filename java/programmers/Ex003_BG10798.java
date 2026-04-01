// 백준: https://www.acmicpc.net/problem/10798

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex003_BG10798 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int maxLength = 0;
        char[][] arr = new char[5][15];
        for (int i = 0; i < 5; i++) {
            String line = br.readLine();

            int length = line.length();
            if(length>maxLength) maxLength = length;

//            // 여기가 잘못 된 거임. 이렇게 넣는 순간 String[][5]가 되어버려 (15가 아니라)
//            System.out.println("넣기 전 길이: " +arr[i].length); // 15
//            arr[i] = line.split("");
//            System.out.println("넣은 후 길이: " +arr[i].length); // 5
            // Q. 만약 arr[i].length의 길이가 i 마다 달라진다면 어떻게 될까? 우리는 지금까지 배열은 무조건 직사각형이라 배웠어. 즉 행마다 길이 다른 배열은 존재할 수 없어
            // 그러면 arr[i]에 넣으려고 할 때 길이가 다르면 오류가 나려나??
            for (int j = 0; j <length; j++) {
                arr[i][j] = line.charAt(j);
            }
            for (int j = length; j < 15; j++) {
                arr[i][j]='*';
            }
        }

        for(int j = 0; j < maxLength; j++){
            for (int i = 0; i < 5; i++) {
                char ch = arr[i][j];
                if (ch == '*') continue;
                System.out.print(ch);
            }
        }

        // 다른 풀이: 굳이 '*'를 넣지 않고 공백 자체로 비교
            // '\u0000'의 아스키코드 0
            // if (arr[i][j]==0) continue;

    }

}
