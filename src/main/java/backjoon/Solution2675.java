package backjoon;

public class Solution2675 {
    public static void main(String[] args) {

        String test = "/HTP";
        int repeatCnt = 5;

        System.out.println(solution(test, repeatCnt));

    }

    private static String solution(String test, int repeatCnt) {
        StringBuilder stringBuilder = new StringBuilder();
        String[] split = test.split("");
        for (String s : split) {
            stringBuilder.append(String.valueOf(s).repeat(Math.max(0, repeatCnt)));
        }
        return stringBuilder.toString();
    }
}
