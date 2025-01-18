package todo.task;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import todo.category.Category;
import todo.category.CategoryService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/task")
public class TaskRestlet {
    @Autowired
    private TaskService taskService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("")
    public List<Task> getAllTask() {
        return taskService.getAllTasks();
    }

    @PostMapping("")
    public Task addTask(@RequestBody Task task) {
        return taskService.addTask(task);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable int id) {
        taskService.deleteTask(id);
    }

    @PutMapping("/{id}")
    public Task updateTask(@PathVariable int id, @RequestBody Task task) {
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

    @GetMapping("/category/{categoryId}")
    public List<Task> getTasksByCategory(@PathVariable Integer categoryId) {
        Optional<Category> category = categoryService.getCategoryById(categoryId);

        if (category.isPresent()) {
            Category existing = category.get();
            return taskService.getTasksByCategory(existing);
        } else {
            throw new NullPointerException("Category not found");
        }
    }

    @GetMapping("/sorted-by-priority")
    public List<Task> getAllTasksSortedByPriority() {
        return taskService.getAllTasksSortedByPriority();
    }

}
