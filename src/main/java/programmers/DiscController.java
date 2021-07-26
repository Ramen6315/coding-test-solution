package programmers;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

//: TODO 나중에 다시 볼것
// 참고 : https://velog.io/@hyeon930/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EB%94%94%EC%8A%A4%ED%81%AC-%EC%BB%A8%ED%8A%B8%EB%A1%A4%EB%9F%AC-Java
public class DiscController {
    public static void main(String[] args) {
        int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};

        System.out.println(solution(jobs));
    }

    public static int solution(int[][] jobs) {
        int cnt = 0;
        int answer = 0;

        LinkedList<Job> waiting = new LinkedList<>();
        PriorityQueue<Job> pq = new PriorityQueue<>(Comparator.comparingInt(job1 -> job1.workingTime));
        for(int[] job : jobs) {
            waiting.offer(new Job(job[0], job[1]));
        }
        waiting.sort(Comparator.comparingInt(o -> o.requestTime));
        int time = waiting.peek().requestTime;
        while(cnt < jobs.length) {
            while(!waiting.isEmpty() && waiting.peek().requestTime <= time) {
                pq.offer(waiting.pollFirst());
            }
            if(!pq.isEmpty()) {
                Job job = pq.poll();
                time += job.workingTime;
                answer += time - job.requestTime;
                cnt++;
            } else {
                time++;
            }
        }

        return answer / cnt;
    }

    static class Job {
        int requestTime;
        int workingTime;

        Job(int requestTime, int workingTime) {
            this.requestTime = requestTime;
            this.workingTime = workingTime;
        }
    }
}

