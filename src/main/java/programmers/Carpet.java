package programmers;

public class Carpet {
    public static void main(String[] args) {
        int[] answer = solution(10, 2);
        for (int ans : answer) {

            System.out.println(ans);
        }
    }

    public static int[] solution(int brown, int yellow) {
        int size = brown + yellow;
        int row = 3;
        int column = 3;
        int startBrown = 6;
        int startYellow = 1;
        int calculateColumn = 0;
        for (int i = 0; i < brown; i++) {
            if ( yellow % startYellow == 0) {
                calculateColumn = calculateSize(yellow, startYellow, column);
                System.out.println(calculateColumn + "," + row + " : " + calculateColumn * row);

                if(row >= calculateColumn && (calculateColumn * row) == size) {
                    break;
                }
            }
            row++;
            startBrown += 2;
            startYellow++;
        }

        int[] answer = new int[]{row, calculateColumn};
        return answer;
    }

    private static int calculateSize(int yellow, int startYellow, int column) {
        int yellowColumn = yellow / startYellow;

        column += yellowColumn-1;
        return column;
    }


}
