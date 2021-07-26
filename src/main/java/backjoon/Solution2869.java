package backjoon;

public class Solution2869 {
    public static void main(String[] args) {
        int up = 100;
        int down = 99;
        int target = 100000000;
        System.out.println(solution(up, down, target));
    }

    private static int solution(int up, int down, int target) {
        int day = 1;
        int dailyUp = up;
        if(dailyUp >= target) {
            return day;
        }
        dailyUp -= down;
        while(dailyUp < target) {
            if(dailyUp + up >= target) {
                return day+1;
            }
            dailyUp += (up - down);
            day++;
        }
        return day;
    }
}
