package no01_카카오기출;

import java.util.*;

public class Ex006_주차요금계산_0822 {

	public static void main(String[] args) {

//		int[] fees = {180, 5000, 10, 600};
//		String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};

		int[] fees = {120, 0, 60, 591};
		String[] records = {"16:00 3961 IN","16:00 0202 IN","18:00 3961 OUT","18:00 0202 OUT","23:58 3961 IN"};

//		int[] fees = {1, 461, 1, 10};
//		String[] records = {"00:00 1234 IN"};

		SortedMap<String, Integer> sumMap = new TreeMap<>();
		Map<String, Integer> timeMap = new HashMap<>();

		// int[]는 [ 누적결과, IN인 시간 ]
		for (String record : records) {
			String[] recordArr = record.split(" ");

			// 시간은 분 처리
			String[] tmp = recordArr[0].split(":");
			int time = Integer.parseInt(tmp[0])*60+Integer.parseInt(tmp[1]);
			// 차량 변호
			String carNum = recordArr[1];
			// IN, OUT
			String INOUT = recordArr[2];

			// sumMap에 없으면 초기화
			if (!sumMap.containsKey(carNum)) sumMap.put(carNum, 0);

			// IN이면 입력
			if (INOUT.equals("IN")) {
				timeMap.put(carNum, time);
			} else { // OUT이면 누적 계산하고 초기화
				// 들어온 수에서 timeMap 빼고 누적
				sumMap.put(carNum, sumMap.get(carNum) + time - timeMap.get(carNum));
				// IN은 0으로 초기화
				timeMap.put(carNum, -1);
			}
		}

		// 반복문 돌면서 timeMap의 INOUT값이 0 아닌 것은 23:59로 값 구해서 누적하기
		timeMap.forEach((k, v)-> {
			if (v!=-1) {
				sumMap.put(k, sumMap.get(k) + (23 * 60) + 59 - v);
			}
		});

//		System.out.println("=============누적시간==================");
//		sumMap.forEach((k, v) -> System.out.println(k + " : " +v));
//		System.out.println();

		// 이제 요금 계산
		int[] answer = new int[sumMap.size()];
		int idx=0;
		for (int time : sumMap.values()) {
			int fee = fees[1]; // 요금
			time-=fees[0];
//			System.out.println("Math.ceil : " + Math.ceil(time/fees[2]));
			if (time>0) {
				double tmp = (double) time / fees[2];
				fee += (int) Math.ceil(tmp)*fees[3];
			}
			answer[idx++] = fee;

		}
		System.out.println(Arrays.toString(answer));
	}

}
