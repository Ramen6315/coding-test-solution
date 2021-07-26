package backjoon;

import java.util.Arrays;

public class Solution10809 {
    public static void main(String[] args) {
        String input = "baekjoon";
        int[] result = new int[26];
        Arrays.fill(result, -1);
        solution(input, result);

        for (int num : result) {
            System.out.println(num);
        }
    }

    private static void solution(String input, int[] result) {

        String[] split = input.split("");
        for (int i = 0; i < split.length; i++) {
            int s = input.charAt(i) - 97;
            if(result[s] != -1) {
                continue;
            }
            result[s] = i;
        }
    }
}
