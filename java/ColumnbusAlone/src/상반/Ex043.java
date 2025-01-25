package 상반;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Ex043 {

    public static void main(String[] args) throws IOException {
        // https://www.acmicpc.net/problem/19583

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String S = st.nextToken();
        String E = st.nextToken();
        String Q = st.nextToken();

        HashSet<String> beforeSet = new HashSet<>();
        HashSet<String> attendanceSet = new HashSet<>();
        String line;
        while ((line = br.readLine()) != null) {
            st = new StringTokenizer(line);
            String time = st.nextToken();
            String name = st.nextToken();
            if (time.compareTo(S) <= 0) beforeSet.add(name);
            else if (0 <= time.compareTo(E) && time.compareTo(Q) <= 0) {
                if (beforeSet.contains(name)) attendanceSet.add(name);
            }
        }

        System.out.println(attendanceSet.size());
    }

}
