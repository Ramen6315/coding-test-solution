package Dynamic;

public class BackPacking {

    public static void main(String[] args) {
        int[][] items = {{1, 60, 10}, {2, 100, 20}, {3, 120, 30}};
        int cap = 50;
        System.out.println(calculateBackPacking(items, cap));
    }

    private static int calculateBackPacking(int[][] items, int cap) {


        int[][] memorization = new int[items.length+1][cap+1];

        for (int i = 0; i <= items.length; i++) {
            for (int j = 0; j <= cap; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                if (i != 0 && items[i - 1][2] > j) {
                    memorization[i][j] = memorization[i - 1][j];
                } else if (i != 0) {
                    memorization[i][j] = Math.max(memorization[i - 1][j], memorization[i - 1][j - items[i - 1][2]] + items[i - 1][1]);
                }
            }
            for (int[] me : memorization) {
                for (int mo : me) {
                    System.out.print(mo + " : ");
                }
                System.out.println();
            }
            System.out.println();
        }

        return memorization[items.length-1][cap-1];
    }
}
