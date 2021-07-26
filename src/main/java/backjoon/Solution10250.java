package backjoon;

public class Solution10250 {
    public static void main(String[] args) {
        int width = 50;
        int height = 30;
        int waitNum = 72;

        solution(width, height, waitNum);
    }

    private static int solution(int width, int height, int waitNum) {
        int roomNum = waitNum / height;
        int roomFloor = waitNum % height;
        int result = 0;
        if(roomNum > width) {
            return -1;
        }
        result += roomFloor * 100;
        result += roomNum + 1;
        return result;
    }
}
