import java.util.ArrayList;
import java.util.List;

public class TodoManager {
    private List<Task> tasks;

    public TodoManager() {
        this.tasks = new ArrayList<>();
    }

    public Task addTask(String description) {
        Task task = new Task(description);
        tasks.add(task);
        return task;
    }

    public List<Task> listTasks() {
        return new ArrayList<>(tasks);
    }

    public Task removeTask(int index) {
        if (index < 0 || index >= tasks.size()) {
            throw new IndexOutOfBoundsException("Índice da tarefa inválido.");
        }
        return tasks.remove(index);
    }

    public void markTaskCompleted(int index) {
        if (index < 0 || index >= tasks.size()) {
            throw new IndexOutOfBoundsException("Índice da tarefa inválido.");
        }
        tasks.get(index).markCompleted();
    }
}
