package no05_Arrays;

public class Ex01_배열생성 {

	public static void main(String[] args) {
		
		// 배열 : "같은 타입"의 여러 변수를 하나의 묶음으로 다룸
			// 순차적 => 인덱스
			// 길이 고정
			// 주소를 참조 => 콜 바이 레퍼런스
		
		// 선언 & 할당
		//         ↓ 대괄호는 배열을 의미
		// 데이터타입[ ] 변수명 = new 데이터타입[배열크기];
		//    (좌변) 선언          (우변) 할당
		int[] arr = new int[3];
		arr[0] = 10;
		arr[1] = 20;
		arr[2] = 30;
		//                   ↓ 중괄호 사용해서 바로 값 넣기
		// 데이터타입[ ] 변수명 = {ㅇ, ㅇ, ㅇ};		
		String[] arr2 = {"Hello", "Java", "World"};
		
		
		// 각 원소에 접근하기(값 넣기, 출력하기 등) : for문 돌려서 arr[i]
		for(int i=0; i<arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
}
