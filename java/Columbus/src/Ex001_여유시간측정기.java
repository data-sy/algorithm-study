import java.time.Duration;
import java.time.LocalTime;
import java.util.Scanner;

public class Ex001_여유시간측정기 {
	public static void main(String[] args) {

		// 저녁 6시
		LocalTime eveningSix = LocalTime.of(18, 0);
		// 현재 시간
		LocalTime currentTime = LocalTime.now();
		// 현재 시간과 저녁 6시의 차이 계산
		Duration diff6 = Duration.between(currentTime, eveningSix);

//		System.out.println("저녁 6시부터 현재까지의 시간 차이: " + diff6);

		// 7시간
		LocalTime sevenHour = LocalTime.of(7, 0);
		// 입력 받은 시간 구하기
		Scanner scanner = new Scanner(System.in);
		System.out.print("현재 공부한 시간을 입력하세요. (예: 3 26): ");
		int hour = scanner.nextInt();
		int minute = scanner.nextInt();
		LocalTime inputTime = LocalTime.of(hour, minute);
		// 입력 받은 사간과 7시간의 차이 계산
		Duration diff7 = Duration.between(inputTime, sevenHour);

//		System.out.println("남은 채워야 하는 시간 : " + diff7);

		// 여유 시간 계산
		Duration time = diff6.minus(diff7);

		// 차이 출력
		long hours = time.toHours();
		long minutes = time.minusHours(hours).toMinutes();
		System.out.printf(" 여유 시간 : %02d시간 %02d분%n", hours, minutes);

		scanner.close();

	}

}
