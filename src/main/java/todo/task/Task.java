package todo.task;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;
import jakarta.persistence.ManyToOne;
import todo.category.Category;
import todo.priority.Priority;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Task entity for the Todo application.
 */
@Entity
@Table(name = "task")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Task {

    /**
     * Task ID.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * Task name.
     */
    private String name;

    /**
     * Task description.
     */
    private String description;

    /**
     * Task priority.
     */
    @Enumerated(EnumType.ORDINAL)
    private Priority priority;

    /**
     * Task category.
     */
    @ManyToOne
    private Category category;
}
