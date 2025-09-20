import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

class Task {
    private int userid;
    private int taskid;
    private int priority;

    public Task(int userid, int taskid, int priority) {
        this.userid = userid;
        this.taskid = taskid;
        this.priority = priority;
    }

    public int getUserid() {
        return userid;
    }

    public int getTaskid() {
        return taskid;
    }

    public int getPriority() {
        return priority;
    }
}

class TaskManager {

    Comparator<Task> cmp = (a, b) -> {
        int diff = b.getPriority() - a.getPriority();
        if (diff == 0) {
            return b.getTaskid() - a.getTaskid();
        }
        return diff;
    };

    HashMap<Integer, PriorityQueue<Task>> userMap = new HashMap<>();

    public TaskManager(List<List<Integer>> tasks) {
        for (List<Integer> current : tasks) {
            int userid = current.get(0);
            Task newTask = new Task(userid, current.get(1), current.get(2));
            if (userMap.containsKey(userid)) {
                userMap.get(userid).offer(newTask);
            } else {
                PriorityQueue<Task> newQueue = new PriorityQueue<>(cmp);
                newQueue.offer(newTask);
                userMap.put(userid, newQueue);
            }
        }
    }

    public void add(int userId, int taskId, int priority) {
        Task newTask = new Task(userId, taskId, priority);
        if (userMap.containsKey(userId)) {
            userMap.get(userId).offer(newTask);
        } else {
            PriorityQueue<Task> newQueue = new PriorityQueue<>(cmp);
            newQueue.offer(newTask);
            userMap.put(userId, newQueue);
        }
    }

    public void edit(int taskId, int newPriority) {

    }

    public void rmv(int taskId) {

    }

    public int execTop() {
        return 1;
    }
}

public class lc_3408 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
    }
}
