package todo.task;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import todo.category.Category;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {
    List<Task> findByCategory(Category category);

    @Query("SELECT t FROM Task t ORDER BY t.priority DESC")
    List<Task> findAllTasksSortedByPriority();
}
