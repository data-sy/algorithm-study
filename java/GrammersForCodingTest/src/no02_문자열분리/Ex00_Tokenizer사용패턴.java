package no02_문자열분리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex00_Tokenizer사용패턴 {
		
	public static void main(String[] args) throws IOException {
		// 0. 문제 상황
			// 행 - 띄어쓰기, 열 - 엔터로 여러 데이터가 들어올 때
			// readLine에 한 행의 데이터가 들어가고 nextToken으로 행 안의 원소가 하나씩 빠져나가
			// 즉, 열의 개수 = readLine 개수 = st 개수 . 한 행에 데이터 개수 = nextToken 개수
		
		// 1. 버퍼리더 (1 예외 던지기,  2 입력인자를 차례 차례 넣기)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 2. 버퍼리더의 readLine을 토크나이저로 받기
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 3. 토크나이저의 nextToken으로 하나씩 꺼내기. 이 때, 필요하면 형변환
        int num1 = Integer.parseInt(st.nextToken());
        int num2 = Integer.parseInt(st.nextToken());
        int num3 = Integer.parseInt(st.nextToken());
        
        // 4. 다음 열은 다시 1~3 반복

	}

}
