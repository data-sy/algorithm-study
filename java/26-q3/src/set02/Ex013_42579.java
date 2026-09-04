package src.set02;

import java.util.*;

public class Ex013_42579 {

    // 인텔리제이의 자동완성 기능에 기대어 풀어버림. 주말에 프로그래머스 비우고 백지에서 다시 풀어보자.

    // 문제: 베스트앨범
    // https://school.programmers.co.kr/learn/courses/30/lessons/42579
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> genresCountMap = new HashMap<>();
        Map<String, TreeSet<Song>> songsByGenre = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            int play = plays[i];
            String genre = genres[i];
            genresCountMap.put(genre, genresCountMap.getOrDefault(genre, 0) + play);
            Song song = new Song(i, play, genre);
            songsByGenre.computeIfAbsent(genre, k -> new TreeSet<>()).add(song);
        }
        Map<Integer, String> reverseGenres = new TreeMap<>(Comparator.reverseOrder());
        genresCountMap.forEach((genre, count) -> {reverseGenres.put(count, genre);}); // 장르별 재생수가 다르니까 가능
        List<Integer> songIds = new ArrayList<>();
        for (String genre : reverseGenres.values()) {
            TreeSet<Song> songs = songsByGenre.get(genre);
            songIds.add(songs.pollFirst().id);
            if (!songs.isEmpty()) {
                songIds.add(songs.pollFirst().id);
            }
        }
        return songIds.stream().mapToInt(Integer::intValue).toArray();
    }
    static class Song implements Comparable<Song> {
        int id;
        int plays;
        String genre;
        Song(int id, int plays, String genre) {
            this.id = id;
            this.plays = plays;
            this.genre = genre;
        }

        @Override
        public int compareTo(Song o) {
            if (this.plays != o.plays) {
                return Integer.compare(o.plays, this.plays);
            }
            return Integer.compare(this.id, o.id);
        }
    }


    // ===== 아래는 채점용. 풀이만 위에서 수정하면 됩니다 =====

    public static void main(String[] args) {
        Ex013_42579 s = new Ex013_42579();

        check(1, s.solution(
                new String[]{"classic", "pop", "classic", "classic", "pop"},
                new int[]{500, 600, 150, 800, 2500}), new int[]{4, 1, 3, 0});
    }

    private static void check(int no, int[] actual, int[] expected) {
        System.out.printf("예 #%d  [%s]  기대값=%s  내결과=%s%n",
                no, Arrays.equals(actual, expected) ? "PASS" : "FAIL",
                Arrays.toString(expected), Arrays.toString(actual));
    }
}
