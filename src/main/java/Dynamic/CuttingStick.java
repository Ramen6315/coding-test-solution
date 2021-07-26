package Dynamic;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CuttingStick {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        int[] price = {0, 1, 5, 8, 9, 10, 17, 17, 20, 24, 30};
        System.out.println(calculateMaxPrice(price, length));

    }

    private static int calculateMaxPrice(int[] price, int length) {
        int q;
        List<Integer> memories = new ArrayList<>();
        for (int i = 1; i <= length; i++) {
            q = 0;
            for (int j = 1; j < i; j++) {
                q = Math.max(q, price[i] + memories.get(j - 1));
            }
            memories.add(q);
        }
        System.out.println(memories);
        return memories.get(length-1);
    }
}
