package backjoon;

public class Solution4673 {
    public static void main(String[] args) {
        boolean[] self = new boolean[10000];
        solution(self);
        for (int i=0; i < self.length; i++) {
            if(!self[i]) {

                System.out.println(i+1);
            }
        }
    }

    private static void solution(boolean[] self) {
        for(int i=0; i < self.length; i++) {
            if(self[i]) {
                continue;
            }
            int num = i + 1;

            while(num < 10000) {
                int eachSum = 0;
                String str = Integer.toString(num);
                String[] split = str.split("");

                for (String s : split) {
                    eachSum += Integer.parseInt(s);
                }
                num += eachSum;
                if(num > 10000) {
                    continue;
                }
                self[num-1] = true;
            }
        }
    }
}
