package todo.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import todo.category.Category;

import java.util.List;
import java.util.Optional;

/**
 * Service class for managing tasks.
 */
@Service
public final class TaskService {

    /**
     * Repository for tasks.
     */
    @Autowired
    private TaskRepository taskRepository;

    /**
     * Retrieves all tasks.
     *
     * @return a list of tasks
     */
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    /**
     * Retrieves a task by its ID.
     *
     * @param id the task ID
     * @return the task
     */
    public Optional<Task> getTaskById(final int id) {
        return taskRepository.findById(id);
    }

    /**
     * Adds a new task.
     *
     * @param task the task to add
     * @return the added task
     */
    public Task addTask(final Task task) {
        return taskRepository.save(task);
    }

    /**
     * Updates an existing task.
     *
     * @param task the task to update
     * @return the updated task
     */
    public Task updateTask(final Task task) {
        return taskRepository.save(task);
    }

    /**
     * Deletes a task by its ID.
     *
     * @param id the task ID
     */
    public void deleteTask(final int id) {
        taskRepository.deleteById(id);
    }

    /**
     * Retrieves tasks by category.
     *
     * @param category the category
     * @return a list of tasks
     */
    public List<Task> getTasksByCategory(final Category category) {
        return taskRepository.findByCategory(category);
    }

    /**
     * Retrieves all tasks sorted by priority.
     *
     * @return a list of tasks
     */
    public List<Task> getAllTasksSortedByPriority() {
        return taskRepository.findAllTasksSortedByPriority();
    }
}
