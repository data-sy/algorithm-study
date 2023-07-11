package no01_콘솔입력;

public class Ex06_ScannerBufferedReader차이 {

	public static void main(String[] args) {
		// 출처 : https://dlee0129.tistory.com/238
		
		// 코테에서 왜 BufferedReader를 쓰는가
		// 결론 : 속도차이 (Scanner 사용 시 시간초과 발생할 때 있음)
		// 원인 : buffer 사용 여부의 차이입니다.
			// Scanner는 1KB 크기의 버퍼를 갖기 때문에 입력이 바로 전달
				// 또한, 입력을 읽는 과정에서 정규 표현식 적용, 입력값 분할, 파싱 과정 등을 거치므로 느림
			// BufferedReader는 8KB 크기의 버퍼를 가지므로
				// buffer에 입력들을 저장하였다가 한 번에 전송 => 속도 빠름
		
		// 출처 : https://www.inflearn.com/questions/178356/comment/100741
		// 결론 : 확장성
			// Scanner는 콘솔에서 데이터를 입력받음
		// 향후에 데이터를 입력 받을 때는 대부분 네트워크나 다른 장치에서 입력을 받기 때문에
			// BufferedReader를 사용해 보시는것이 확장성이 좋아서 입니다.^~^
	}

}
