import java.util.*;

class Task implements Comparable<Task> {
    int userId;
    int taskId;
    int priority;

    public Task(int userId, int taskId, int priority) {
        this.userId = userId;
        this.taskId = taskId;
        this.priority = priority;
    }

    @Override
    public int compareTo(Task other) {
        if (this.priority != other.priority) {
            return other.priority - this.priority;
        }
        return this.taskId - other.taskId;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Task) {
            Task other = (Task) obj;
            return this.taskId == other.taskId;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(taskId);
    }
}

public class que3 {
    private Map<Integer, Task> taskMap;
    private PriorityQueue<Task> taskQueue;

    public que3() {
        taskMap = new HashMap<>();
        taskQueue = new PriorityQueue<>();
    }

    public void addTask(int userId, int taskId, int priority) {
        Task task = new Task(userId, taskId, priority);
        taskMap.put(taskId, task);
        taskQueue.add(task);
    }

    public void removeTask(int taskId) {
        Task task = taskMap.remove(taskId);
        if (task != null) {
            taskQueue.remove(task);
        }
    }

    public void editTask(int taskId, int newPriority) {
        if (taskMap.containsKey(taskId)) {
            Task oldTask = taskMap.get(taskId);
            taskQueue.remove(oldTask);
            Task newTask = new Task(oldTask.userId, taskId, newPriority);
            taskMap.put(taskId, newTask);
            taskQueue.add(newTask);
        }
    }

    public int getTopTask() {
        while (!taskQueue.isEmpty()) {
            Task top = taskQueue.peek();
            if (taskMap.containsKey(top.taskId)) {
                return top.taskId;
            } else {
                taskQueue.poll();
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        que3 tm = new que3();
        tm.addTask(1, 101, 5);
        tm.addTask(2, 102, 10);
        tm.addTask(3, 103, 10);

        System.out.println("Top Task: " + tm.getTopTask());
        tm.removeTask(102);
        System.out.println("Top Task after removing 102: " + tm.getTopTask());
        tm.editTask(103, 3);
        System.out.println("Top Task after editing 103 to priority 3: " + tm.getTopTask());
    }
}
