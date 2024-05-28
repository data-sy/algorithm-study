package no04_기말고사;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex056_21카카오_신규아이디 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String new_id = br.readLine();

		// 규칙 1
		new_id = new_id.toLowerCase();

		// 규칙 2
		new_id = new_id.replaceAll("[^a-z0-9-_.]", "");

		// 규칙 3, 4
		String[] spl = new_id.split("\\.");
		for(int i=0; i<spl.length; i++){
			if(spl[i].length()>0) sb.append(spl[i]).append(".");
		}
		if (sb.length()>1) sb.setLength(sb.length()-1);

		// 규칙 5
		if (sb.length()==0) sb.append("a");

		// 규칙 6
		if (sb.length()>15) sb.setLength(15);
		String str = sb.toString();
		if (str.charAt(str.length()-1)=='.') sb.setLength(sb.length()-1);

		// 규칙 7
		str = sb.toString();
		int len = str.length();
		String tmp = Character.toString(str.charAt(str.length()-1));
		if (len == 2) sb.append(tmp);
		else if (len == 1) sb.append(tmp).append(tmp);

		System.out.println(sb.toString());

	}

}
