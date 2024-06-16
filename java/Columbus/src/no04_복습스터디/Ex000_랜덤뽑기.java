package no04_복습스터디;

import java.util.Random;

public class Ex000_랜덤뽑기 {
    public static void main(String[] args) {

        // 참고 : https://velog.io/@sjsrkdgks/입력한-수-만큼-중복없이-뽑기
            // Math.random()은 0.0이상 1.0미만의 double 난수 생성
            // 여기에 *25를 하면 0.0이상 25.0미만의 더블 => int로 형변환하면 0~24사이의 int
            // 이 풀이 틀렸음!!
        // 랜덤.nextInt 사용하기

        Random rand = new Random();

        // 요일 배열
        String[] week = {"월 : ", "화 : ", "수 : ", "목 : ", "금 : "};

        // 문제 배열
        int[] items = {1940, 9012, 1373, 18115, 11720, 13305, 2609, 1157, 1406, 1620, 10816, 1343, 1935, 1966, 1929, 2164, 17413, 18258, 9046, 11047, 21921};

        // 문제 무작위 정렬 (각 인덱스마다 랜덤 위치랑 스위치)
        for (int i=0; i<items.length; i++){
//            int r = (int) Math.random()*items.length; // (int) 캐스팅이 먼저 되어 0*25=0
            // 그래서 인덱스 0과 한번 스위치 해서 제자리... ㅋㅋㅋㅋㅋ
            int r = rand.nextInt(items.length); // 이렇게 해야 0이상 25미만의 정수
            for (int j=0; j< items.length; j++) {
                int tmp = items[j];
                items[j] = items[r];
                items[r] = tmp;
            }
        }

        // 앞에서부터 3개씩 요일 배치
        for (int i=0; i< week.length; i++){
            System.out.print(week[i]);
            int j = i*3;
            System.out.println(items[j] + ", " + items[j+1] + ", " +items[j+2]);
        }

    }
}
