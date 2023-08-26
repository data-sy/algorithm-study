package no08_성능테스트;

public class Ex01_시간관련 {

	public static void main(String[] args) {
		
		// System.currentTimeMillis() : 1970년01월01일00시00분과 현재 시간과의 차이를 ms단위로 리턴
		
		// System.nanoTime(); : 상대적인 시간 차이를 나노초 단위로 
		long startTime = System.nanoTime();
			// 기능 실행
		long endTime = System.nanoTime();
			// 걸린 시간
		long time = endTime - startTime;

	}

}
