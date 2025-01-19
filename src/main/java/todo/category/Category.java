package todo.category;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Category entity for the Todo application.
 */
@Entity
@Table(name = "category")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Category {

    /**
     * Category ID.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    /**
     * Category name.
     */
    @Column(unique = true, nullable = false)
    String name;

    public Category(int id) {
        this.id = id;
    }
}
