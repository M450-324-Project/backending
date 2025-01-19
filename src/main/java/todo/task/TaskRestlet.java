package todo.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import todo.category.Category;
import todo.category.CategoryService;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing tasks.
 */
@RestController
@RequestMapping("/api/task")
public final class TaskRestlet {

    /**
     * Service for tasks.
     */
    @Autowired
    private TaskService taskService;

    @Autowired
    private CategoryService categoryService;

    /**
     * Retrieves all tasks.
     *
     * @return a list of tasks
     */
    @GetMapping
    public List<Task> getAllTask() {
        return taskService.getAllTasks();
    }

    /**
     * Adds a new task.
     *
     * @param task the task to add
     * @return the added task
     */
    @PostMapping
    public Task addTask(@RequestBody final Task task) {
        return taskService.addTask(task);
    }

    /**
     * Deletes a task by its ID.
     *
     * @param id the task ID
     */
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable final int id) {
        taskService.deleteTask(id);
    }

    /**
     * Updates an existing task.
     *
     * @param id the task ID
     * @param task the task to update
     * @return the updated task
     */
    @PutMapping("/{id}")
    public Task updateTask(@PathVariable final int id, @RequestBody final Task task) {
        Optional<Task> existingTask = taskService.getTaskById(id);

        if (existingTask.isPresent()) {
            Task exist = existingTask.get();
            exist.setCategory(task.getCategory());
            exist.setDescription(task.getDescription());
            exist.setPriority(task.getPriority());
            exist.setName(task.getName());
            return taskService.updateTask(exist);
        } else {
            throw new NullPointerException("Task not found");
        }
    }

    /**
     * Retrieves tasks by category.
     *
     * @param categoryId the category ID
     * @return a list of tasks
     */
    @GetMapping("/category/{categoryId}")
    public List<Task> getTasksByCategory(@PathVariable final Integer categoryId) {
        Optional<Category> category = categoryService.getCategoryById(categoryId);

        if (category.isPresent()) {
            Category existing = category.get();
            return taskService.getTasksByCategory(existing);
        } else {
            throw new NullPointerException("Category not found");
        }
    }

    /**
     * Retrieves all tasks sorted by priority.
     *
     * @return a list of tasks
     */
    @GetMapping("/sorted-by-priority")
    public List<Task> getAllTasksSortedByPriority() {
        return taskService.getAllTasksSortedByPriority();
    }

}
