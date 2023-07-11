package no01_콘솔입력;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class BufferedReader사용패턴 {
										// 1. 예외처리 던지기
	public static void main(String[] args) throws IOException {
		// 2. 입력인자를 차례 차례 넣기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	}

}
