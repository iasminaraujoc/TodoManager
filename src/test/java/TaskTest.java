import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class TaskTest {

    private Task task;

    @BeforeEach
    public void setUp() {
        task = new Task("Estudar Java");
    }

    @Test
    public void testTaskInitialization() {
        assertEquals("Estudar Java", task.getDescription());
        assertFalse(task.isCompleted());
        assertNull(task.getCompletedAt());
    }

    @Test
    public void testMarkCompleted() {
        task.markCompleted();

        assertTrue(task.isCompleted());
        assertNotNull(task.getCompletedAt());

        // Verificar se o momento de conclusão é próximo ao atual
        LocalDateTime now = LocalDateTime.now();
        assertTrue(task.getCompletedAt().isBefore(now.plusSeconds(1)));
        assertTrue(task.getCompletedAt().isAfter(now.minusSeconds(1)));
    }

    @Test
    public void testInvalidDescription() {
        assertThrows(IllegalArgumentException.class, () -> new Task(""));
        assertThrows(IllegalArgumentException.class, () -> new Task(null));
    }
}
