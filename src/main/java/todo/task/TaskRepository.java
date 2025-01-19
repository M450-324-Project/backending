package todo.task;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import todo.category.Category;

import java.util.List;

/**
 * Repository interface for Task entities.
 */
@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {

    /**
     * Finds tasks by category.
     *
     * @param category the category
     * @return a list of tasks
     */
    List<Task> findByCategory(Category category);

    /**
     * Finds all tasks ordered by priority.
     *
     * @return a list of tasks
     */
    @Query("SELECT t FROM Task t ORDER BY t.priority DESC")
    List<Task> findAllTasksSortedByPriority();
}
