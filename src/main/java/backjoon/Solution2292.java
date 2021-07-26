package backjoon;
//TODO: 나중에 다시 확인
public class Solution2292 {
    public static void main(String[] args) {
        int num = 8;
        System.out.println(solution(num));
    }

    private static int solution(int num) {
        int result = 1;
        int range = 1;
        int temp = 1;

        while(true) {
            if(range >= num) {
                break;
            }
            temp = 6 * (result++);
            range += temp;
        }
        return result;
    }
}
