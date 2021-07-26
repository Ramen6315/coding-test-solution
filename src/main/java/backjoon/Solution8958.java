package backjoon;

public class Solution8958 {
    public static void main(String[] args) {
        String input = "OOOOXOOOOXOOOOX";
        System.out.println(solution(input));
    }

    private static int solution(String inputs) {
        String[] input = inputs.split("");
        int result  = 0;
        int total = 0;
        boolean isCorrect = false;
        for (int i = 0; i < input.length; i++) {
            if(input[i].equals("O") && !isCorrect) {
                total++;
                isCorrect = true;
                result += total;
            } else if(input[i].equals("O") && isCorrect) {
                total++;
                result += total;
            } else if(input[i].equals("X")) {
                isCorrect = false;
                total = 0;
            }
        }
        return result;
    }
}
