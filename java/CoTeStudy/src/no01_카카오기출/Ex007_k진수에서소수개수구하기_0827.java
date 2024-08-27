package no01_카카오기출;

public class Ex007_k진수에서소수개수구하기_0827 {

	public static void main(String[] args) {

//		int n = 437674;
//		int k = 3;

		int n = 110011;
		int k = 10;

		StringBuilder sb = new StringBuilder();

		while(n!=0){
			sb.append(n%k);
			n/=k;
		}

		String[] strArr = sb.reverse().toString().split("0");

		int answer = 0;

		for (String str : strArr) {
			if (str.equals("")) continue;
			answer += isPrime(Long.parseLong(str));
		}
		System.out.println(answer);

	}

	static int isPrime (long num) { // 소수이면 1, 아니면 0을 리턴
		int result = 1;
		if (num==1) return 0;
		else {
			for (long i=2; i<=(long)Math.sqrt(num); i++) {
				if (num%i==0) {
//					System.out.println(num + "은 소수가 아님");
					result=0;
					break;
				}
			}
			return result;
		}
	}

}
