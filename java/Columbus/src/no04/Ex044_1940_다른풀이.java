package no04;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex044_1940_다른풀이 {

    public static void main(String[] args) throws IOException {
    	// https://www.acmicpc.net/problem/1940

    	// 다른 풀이 https://www.acmicpc.net/source/62503615 (성능 16316 172)
    	// (M-들어온 값)을 이미 visited한 적이 있으면 (= 가지고 있다는 거니까) cnt++, 사용했으니까 false로 바꿔주기 
    	// visited 한 적이 없으면 들어온 값을 true로 (= 가지게 되었으니까)
    	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
	
	    int N = Integer.parseInt(br.readLine());
	    int M = Integer.parseInt(br.readLine());
	
	    st = new StringTokenizer(br.readLine());
	
	    boolean [] visited = new boolean[100001];
	
	    int ans = 0;
	
	    for (int i = 0 ; i < N ; i++) {
	        int now = Integer.parseInt(st.nextToken());
	
	        if (M - now > 100000 || M - now < 0) continue;
	        if (visited[M - now]) {
	            ans++;
	            visited[M - now] = false;
	        } else {
	            visited[now] = true;
	        }
	    }
	
	    System.out.println(ans);
	}
}
