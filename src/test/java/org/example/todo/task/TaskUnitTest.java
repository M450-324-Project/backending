package org.example.todo.task;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import todo.category.Category;
import todo.category.CategoryService;
import todo.priority.Priority;
import todo.task.Task;
import todo.task.TaskRepository;
import todo.task.TaskService;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class TaskUnitTest {
    @Mock
    private TaskRepository taskRepository;


    @InjectMocks
    private TaskService taskService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindAllTasks() {
        Task task = new Task();
        task.setName("Baking");
        when(taskRepository.findAll()).thenReturn(Collections.singletonList(task));

        List<Task> result = taskService.getAllTasks();

        verify(taskRepository, times(1)).findAll();
        assertEquals(1, result.size());
        assertEquals("Baking", result.get(0).getName());
    }

    @Test
    void testAddTask() {
        Task task = new Task();
        task.setName("Testing");
        taskService.addTask(task);

        verify(taskRepository, times(1)).save(any(Task.class));
    }

    @Test
    void testUpdateTask() {
        Task changer = new Task();
        changer.setName("test1");
        changer.setId(4);
        Task newChange = changer;
        newChange.setName("test2");

        when(taskRepository.findById(4)).thenReturn(Optional.of(changer));

        taskService.updateTask(newChange);

        verify(taskRepository, times(1)).save(newChange);
        assertEquals(changer.getName(), newChange.getName());
    }

    @Test
    void testDeleteTask() {
        Task task = new Task();
        task.setName("delting");
        task.setId(4);

        when(taskRepository.findById(4)).thenReturn(Optional.of(task));

        taskService.deleteTask(4);

        verify(taskRepository, times(1)).deleteById(4);
    }

    @Test
    void testGetTasksByCategory() {
        Category category = new Category();
        category.setName("Baking");
        category.setId(1);
        Task task = new Task();
        task.setName("yuhu");
        task.setCategory(category);
        task.setId(4);

        when(taskRepository.findByCategory(category)).thenReturn(Collections.singletonList(task));

        List<Task> result = taskService.getTasksByCategory(category);


        verify(taskRepository, times(1)).findByCategory(category);
        assertEquals(1, result.size());
        assertEquals("yuhu", result.get(0).getName());
    }

    @Test
    void testGetAllTasksSortedByPriority() {
        Task task1 = new Task();
        task1.setName("test1");
        task1.setPriority(Priority.LOW);
        Task task = new Task();
        task.setName("yuhu");
        task.setPriority(Priority.HIGH);

        when(taskRepository.findAllTasksSortedByPriority()).thenReturn(Arrays.asList(task, task1));

        List<Task> result = taskService.getAllTasksSortedByPriority();


        verify(taskRepository, times(1)).findAllTasksSortedByPriority();
        assertEquals(2, result.size());
        assertEquals("yuhu", result.get(0).getName());
    }
}
