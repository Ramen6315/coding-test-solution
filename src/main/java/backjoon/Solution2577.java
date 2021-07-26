package backjoon;

import java.util.Scanner;

public class Solution2577 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int first = scanner.nextInt();
        int second = scanner.nextInt();
        int third = scanner.nextInt();
        solution(first, second, third);

    }

    private static void solution(int first, int second, int third) {
        int multi = first * second * third;
        String multiStr = String.valueOf(multi);
        String[] eachNums = multiStr.split("");
        int[] result = new int[10];
        for(String num : eachNums) {
            int i = Integer.parseInt(num);
            result[i]++;
        }
        for (int num : result) {
            System.out.println(num);
        }
    }
}
