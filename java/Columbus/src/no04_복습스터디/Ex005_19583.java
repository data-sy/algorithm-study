package no04_복습스터디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Ex005_19583 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String S = st.nextToken();
		String E = st.nextToken();
		String Q = st.nextToken();

		HashSet<String> set = new HashSet<>();
		HashSet<String> setFinal = new HashSet<>();
		String line;
		while ((line = br.readLine()) != null){
			st = new StringTokenizer(line);
			String time = st.nextToken();
			String name = st.nextToken();
			if (time.compareTo(S)<=0) {
				set.add(name);
				continue;
			}
			if (time.compareTo(E)>=0 && time.compareTo(Q)<=0 && set.contains(name)) setFinal.add(name);
		}
		System.out.println(setFinal.size());
	}
}
