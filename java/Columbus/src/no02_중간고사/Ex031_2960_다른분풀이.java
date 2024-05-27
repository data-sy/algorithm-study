package no02_중간고사;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex031_2960_다른분풀이 {
	// https://www.acmicpc.net/problem/2960
	// 버퍼리더를 메인 외부로 뺌 ("클래스 멤버 변수로 선언한다"라고 표현)
	// 코딩테스트 성능에는 영향 없지만, 유지보수에 좋아.
		// 재사용성, 가독성, 상태 유지, 캡슐화, 테스트 용이성 등 
	// 결론 : 변수가 여러 메서드에서 사용되거나, 메서드 호출 간의 데이터 공유가 필요할 때 클래스의 멤버 변수로 선언하는 것이 좋음 
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static boolean[] primeMulti;

	public static void main(String[] args) throws IOException {
		String[] line = br.readLine().split(" ");
		int n = Integer.parseInt(line[0]);
		int k = Integer.parseInt(line[1]);
		
		primeMulti = new boolean[n+1];
		
		// 카운트를 따로 세지 않고 k를 줄이다가 0이 되는 순간이 원하는 개수야!
		// 소수성이 아니라 소수의 배수인지를 배열에 담으면 더 단순해져 
		// 이중 포문 나오기 위해 첫 번째 포문에 조건 달아주면 돼 
		for(int i=2;i<=n && k != 0;i++) {
			for(int j=i;j<=n;j+=i) {
				if(!primeMulti[j]) {
					primeMulti[j] = true;
					k--;
				}
				if(k==0) {
					System.out.println(j);
					break;
				}
			}
		}
	}
}
