package programmers;

import java.util.HashMap;

//TODO: 나중에 한번더 풀어볼 것 2021. 07. 07
public class Camouflage {
    public static void main(String[] args) {
        String[][] clothes = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};
        System.out.println(solution(clothes));
    }

    private static int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (String[] clothe : clothes) {
            if (!hashMap.containsKey(clothe[1])) {
                hashMap.put(clothe[1], 1);
                continue;
            }
            hashMap.put(clothe[1], hashMap.get(clothe[1]) + 1);
        }
        for(String parts : hashMap.keySet()) {
            answer *= hashMap.get(parts) + 1;
        }
        return answer - 1;
    }
}
