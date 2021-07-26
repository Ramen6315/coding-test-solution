package programmers;

import java.util.*;

public class BestAlbum {
    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "classic", "pop", "classic", "classic"};
        int[] plays = {400, 600, 150, 600, 500, 500};
        System.out.println(solution(genres, plays));

    }

    public static int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> genresPlayCountMap = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            if (genresPlayCountMap.containsKey(genres[i])) {
                genresPlayCountMap.put(genres[i], genresPlayCountMap.get(genres[i]) + plays[i]);
                continue;
            }
            genresPlayCountMap.put(genres[i], plays[i]);
        }
        List<String> genresSorts = new ArrayList<>(genresPlayCountMap.keySet());
        genresSorts.sort((i, j) -> (genresPlayCountMap.get(j).compareTo(genresPlayCountMap.get(i))));
        List<Integer> ranks = extractGenreTopTwoPlay(genresSorts, genresPlayCountMap, genres, plays);
        int[] answer = new int[ranks.size()];
        for (int i=0; i < ranks.size(); i++) {
            answer[i] = ranks.get(i);

        }
        return answer;
    }

    private static List<Integer> extractGenreTopTwoPlay(List<String> genresSorts, Map<String, Integer> genresPlayCountMap, String[] genres, int[] plays) {
        List<Integer> ranks = new ArrayList<>();
        List<Integer> tops = new ArrayList<>();
        List<Integer> sortTops = new ArrayList<>();
        int cnt = 0;
        for (String genre : genresSorts) {
            for(int i=0; i< genres.length; i++) {
                if(genres[i].equals(genre)) {
                    tops.add(plays[i]);
                }
            }
            tops.sort(Collections.reverseOrder());
            for(int top : tops) {
                if(cnt == 2) {
                    break;
                }
                sortTops.add(top);
                cnt++;
            }
            tops = new ArrayList<>();
            cnt = 0;
        }

        boolean[] flag = new boolean[plays.length];
        for (int top : sortTops) {
            for(int i=0; i < plays.length; i++) {
                if(plays[i] == top && !flag[i]) {
                    ranks.add(i);
                    flag[i] = true;
                }
            }
        }
        System.out.println(ranks);
        return ranks;
    }
}
