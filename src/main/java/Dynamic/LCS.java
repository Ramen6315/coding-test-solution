package Dynamic;

public class LCS {
    public static void main(String[] args) {
        String[] x = {"A", "B", "C", "B", "D", "A", "B"};
        String[] y = {"B", "D", "C", "A", "B", "A"};
        System.out.println(lcs(x, y));
    }

    private static int lcs(String[] x, String[] y) {
        int[][] result = new int[x.length][y.length];

        for(int i=0; i< x.length; i++) {
            for(int j=0; j< y.length; j++) {
                if((i == 0 || j == 0) && !x[i].equals(y[j])) {
                    result[i][j] = 0;
                } else if((i == 0 || j == 0) && x[i].equals(y[j])) {
                    result[i][j] = 1;
                }

                if((i != 0 && j != 0) && x[i-1].equals(y[j-1])) {
                    result[i][j] = result[i-1][j-1] + 1;
                } else if((i != 0 && j != 0) && !x[i-1].equals(y[j-1])) {
                    result[i][j] = Math.max(result[i][j-1], result[i-1][j]);
                }
            }
        }
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j]);
            }
            System.out.println();
        }
        return result[x.length-1][y.length-1];
    }
}
