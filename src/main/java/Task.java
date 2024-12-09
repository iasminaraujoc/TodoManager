import java.time.LocalDateTime;

public class Task {
    private String description;
    private boolean completed;
    private LocalDateTime completedAt;

    public Task(String description) {
        if (description == null || description.trim().isEmpty()) {
            throw new IllegalArgumentException("A tarefa não pode ser vazia.");
        }
        this.description = description;
        this.completed = false;
        this.completedAt = null;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public LocalDateTime getCompletedAt() {
        return completedAt;
    }

    public void markCompleted() {
        this.completed = true;
        this.completedAt = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "[" + (completed ? "✔" : "✘") + "] " + description +
                (completed ? " (Concluído em: " + completedAt + ")" : "");
    }
}

