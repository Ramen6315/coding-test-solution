package backjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution1546 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int inputSize = scanner.nextInt();
        double sum = 0;
        int max = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < inputSize; i++) {
            int num = scanner.nextInt();
            if (max < num) {
                max = num;
            }
            list.add(num);
        }

        for (int num : list) {
            sum += ((double) num / (double) max) * 100;
        }
        System.out.println(sum / list.size());
    }
}
