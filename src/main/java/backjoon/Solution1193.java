package backjoon;

public class Solution1193 {
    public static void main(String[] args) {
        int num = 15;
        System.out.println(solution(num));
    }

    private static String solution(int num) {
        boolean up = true;
        int upNumber = 1;
        int downNumber = 1;
        int start = 1;
        int t = 0;
        for(int i=1; i<num; i++) {
            if(start + i >= num) {
                break;
            }
            up = !up;
            start += i;
            t++;
        }
        if(up) {
            upNumber = t+1;
            for(int i=start+1; i<=num; i++) {
                downNumber++;
                if(upNumber-1 == 0) {
                    continue;
                }
                  upNumber--;

            }
            return upNumber + "/" + downNumber;
        }
        downNumber = t+1;
        for(int i=start+1; i<=num; i++) {
            upNumber++;
            if(downNumber-1 == 0) {
                continue;
            }

            downNumber--;
        }
        return upNumber + "/" + downNumber;
    }
}
