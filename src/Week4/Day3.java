package Week4;

import java.util.*;
public class Day3 {

    public static void main(String[] args) {
        
        // https://school.programmers.co.kr/learn/courses/30/lessons/176962
        
        String[][] plans = {
                {"A", "12:00", "20"},
                {"B", "12:10", "30"},
                {"C", "12:40", "10"}
        };
        String[] result = solution(plans);
        System.out.println(Arrays.toString(result));
    }

    public static String[] solution(String[][] plans) {
        
        List<Task> tasks = new ArrayList<>();
        for (String[] plan : plans) {
            
            String name = plan[0];
            String[] time = plan[1].split(":");
            int start = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]); // 분단위로 변경
            int playTime = Integer.parseInt(plan[2]);
            tasks.add(new Task(name, start, playTime));
            
        }
        Collections.sort(tasks, (t1, t2) -> t1.start - t2.start);
        
        // 일시 중단한 과제
        PriorityQueue<Task> pausedTasks = new PriorityQueue<>((a, b) -> b.start - a.start);
        // 완료한 과제
        List<String> completedTasks = new ArrayList<>();

        int currentTime = 0;
        for (Task task : tasks) {

            while (!pausedTasks.isEmpty() && currentTime < task.start) {

                Task paused = pausedTasks.poll();

                int remainTime = Math.min(paused.playTime, task.start - currentTime);

                paused.playTime -= remainTime;
                currentTime += remainTime;

                if (paused.playTime == 0) {
                    completedTasks.add(paused.name);
                } else {
                    pausedTasks.add(paused);
                }
            }

            currentTime = task.start;
            if (!pausedTasks.isEmpty() && pausedTasks.peek().start == task.start) {
                pausedTasks.poll().playTime += task.playTime;
            } else {
                pausedTasks.add(task);
            }
        }

        while (!pausedTasks.isEmpty()) {
            Task task = pausedTasks.poll();
            completedTasks.add(task.name);
        }

        String[] answer = new String[tasks.size()];

        for (int i = 0; i < completedTasks.size(); i++) {
            answer[i] = completedTasks.get(i);
        }

        return answer;
    }

    static class Task {
        String name;
        int start;
        int playTime;

        Task(String name, int start, int playTime) {
            this.name = name;
            this.start = start;
            this.playTime = playTime;
        }
    }

}
