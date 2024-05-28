package no04_기말고사;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Ex057_16165 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

        Map<String, LinkedList<String>> map = new HashMap<>();

        // N 번의 걸그룹 입력 받기
        for (int i=0; i<N; i++) {
            String group = br.readLine();
            int cnt = Integer.parseInt(br.readLine());

            LinkedList<String> list = new LinkedList<>();
            for (int j = 0; j < cnt; j++) {
                String mem = br.readLine();
                list.add(mem);
                map.put(mem, new LinkedList<>(Arrays.asList(group)));
            }
            map.put(group, list);
        }

        for (int i=0; i<M; i++){
            String name = br.readLine();
            int quiz = Integer.parseInt(br.readLine());

            if (quiz>0) { // 멤버이름 -> 팀이름
                sb.append(map.get(name).pop()).append("\n");
            } else { // 팀이름 -> 멤버들 이름
                LinkedList<String> members = map.get(name);
                Collections.sort(members);
                members.forEach( e -> sb.append(e).append("\n"));
            }
        }

        System.out.println(sb);
	}

}
