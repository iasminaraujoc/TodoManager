import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;
public class TodoManagerTest {

    private TodoManager todoManager;

    @BeforeEach
    public void setUp() {
        todoManager = new TodoManager();
    }

    @Test
    public void testAddTask() {
        Task task = todoManager.addTask("Comprar leite");
        assertEquals("Comprar leite", task.getDescription());
        assertFalse(task.isCompleted());
        assertNull(task.getCompletedAt());
    }

    @Test
    public void testAddEmptyTask() {
        assertThrows(IllegalArgumentException.class, () -> {
            todoManager.addTask("");
        });
    }

    @Test
    public void testListTasks() {
        todoManager.addTask("Comprar pão");
        todoManager.addTask("Fazer exercício");
        List<Task> tasks = todoManager.listTasks();
        assertEquals(2, tasks.size());
        assertEquals("Comprar pão", tasks.get(0).getDescription());
        assertEquals("Fazer exercício", tasks.get(1).getDescription());
    }

    @Test
    public void testRemoveTask() {
        todoManager.addTask("Ler um livro");
        todoManager.addTask("Estudar Java");
        Task removedTask = todoManager.removeTask(0);
        assertEquals("Ler um livro", removedTask.getDescription());
        assertEquals(1, todoManager.listTasks().size());
    }

    @Test
    public void testRemoveInvalidTask() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            todoManager.removeTask(5);
        });
    }

    @Test
    public void testMarkTaskCompleted() {
        todoManager.addTask("Fazer compras");
        todoManager.markTaskCompleted(0);
        Task task = todoManager.listTasks().get(0);

        assertTrue(task.isCompleted());
        assertNotNull(task.getCompletedAt());

        // Verificar se o momento de conclusão está muito próximo do atual
        LocalDateTime now = LocalDateTime.now();
        assertTrue(task.getCompletedAt().isBefore(now.plusSeconds(1)));
        assertTrue(task.getCompletedAt().isAfter(now.minusSeconds(1)));
    }

    @Test
    public void testMarkInvalidTaskCompleted() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            todoManager.markTaskCompleted(2);
        });
    }
}
