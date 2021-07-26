package programmers;

import java.util.HashSet;
import java.util.Set;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/1845
 */

public class Phoneketmon {
    public static void main(String[] args) {
        int[] nums = {3,3,3,2,2,2};
        System.out.println(solution(nums));
    }

    public static int solution(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int chooseSize = nums.length / 2;
        if(set.size() >= chooseSize) {
            return chooseSize;
        }
        return set.size();
    }
}
