package no09_정규식dp복습;

import java.io.IOException;

public class Ex004_72410_카카오기출_정규식 {

    public static void main(String[] args) throws IOException {
        //https://school.programmers.co.kr/learn/courses/30/lessons/72410

        String new_id = "...!@BaT#*..y.abcdefghijklm";

//        // 5단계 : a 나오는지
//        String new_id = "...!@#...";
//        // 6단계 : 맨 끝이 .이라면 . 제거
//        String new_id = "...!@BaT#*..y.abcdefgh.ijklm";
//        // 7단계 : 3개 붙는지
//        String new_id = "ab";

        StringBuilder sb = new StringBuilder();

        // 1단계
        // Q. 여기도 정규표현식을 사용할 수 있는 방법이 있을까?
        for (int i=0; i<new_id.length(); i++) {
            char ch = new_id.charAt(i);
            if (65<=ch && ch<=90) sb.append((char)(ch + 32));
            else sb.append(ch);
        }

//        System.out.println(sb);

        // 2단계
        new_id = sb.toString().replaceAll("[^a-z0-9-_.]", "");

        // 3단계
        new_id = new_id.replaceAll("\\.{2,}", "\\.");

        // 4단계
        // Q. 이 둘을 한 번에 하는 방법 없을까?
        new_id = new_id.replaceAll("^\\.", "");
        new_id = new_id.replaceAll("\\.$", "");

        // 5단계
        if (new_id.length()==0) new_id = "a";

        // 6단계
        sb.setLength(0);
        sb.append(new_id);
        if (sb.length()>=16) {
            sb.setLength(15);
            new_id = sb.toString();
        }
        new_id = new_id.replaceAll("\\.$", "");


        // 7단계
        int len = new_id.length();
        if (len<=2) {
            sb.setLength(0);
            sb.append(new_id);
            sb.append(Character.toString(new_id.charAt(len - 1)).repeat(3-len));
            new_id = sb.toString();
        }
//        System.out.println(sb);

        System.out.println(new_id);

    }

}
