package programmers;

import java.util.Collections;
import java.util.PriorityQueue;

public class DoublePriorityQueue {
    public static void main(String[] args) {
        String[] operations = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
        int[] answer = solution(operations);
        for (int ans :  answer) {
            System.out.println(ans);
        }
    }

    public static int[] solution(String[] operations) {
        PriorityQueue<Integer> pqDown = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> pqUp = new PriorityQueue<>();
        for (String operation : operations) {
            String[] s = operation.split(" ");
            if(s[0].equals("I")) {
                pqUp.offer(Integer.parseInt(s[1]));
                pqDown.offer(Integer.parseInt(s[1]));
            } else if(s[0].equals("D")) {
                if(s[1].equals("-1") && pqUp.size() != 0) {
                    Integer poll = pqUp.poll();
                    pqDown.remove(poll);

                } else if(s[1].equals("1") && pqUp.size() != 0) {
                    Integer poll = pqDown.poll();
                    pqUp.remove(poll);
                }
            }
        }

        if(pqUp.size() == 0) {
            return new int[]{0, 0};
        }

        int[] answer = new int[]{pqDown.poll(), pqUp.poll()};

        return answer;
    }
}
