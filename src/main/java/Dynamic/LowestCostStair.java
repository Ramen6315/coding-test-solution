package Dynamic;

public class LowestCostStair {
    public static void main(String[] args) {
        int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println(minCoastClimbingStairs(cost));
    }

    public static int minCoastClimbingStairs(int[] cost) {
        int case1 = 0;
        int case2 = 0;
        int current = 0;

        for (int i = cost.length - 1; i >= 0; i--) {
            current = cost[i] + Math.min(case1, case2);
            case2 = case1;
            case1 = current;
        }
        return Math.min(case1, case2);
    }
}
