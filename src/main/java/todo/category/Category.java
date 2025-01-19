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
    private int id;

    /**
     * Category name.
     */
    @Column(unique = true, nullable = false)
    private String name;

    /**
     * Gets the name of the category.
     *
     * @return the name of the category
     */
    public String getName() {
        return this.name;
    }

    /**
     * Sets the name of the category.
     *
     * @param name the name to set
     */
    @SuppressWarnings("checkstyle:HiddenField")
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * Category constructor.
     *
     * @param id the id of the category
     */
    @SuppressWarnings("checkstyle:HiddenField")
    public Category(final int id) {
        this.id = id;
    }

    /**
     * Sets the id of the category.
     *
     * @param id the id to set
     */
    @SuppressWarnings("checkstyle:HiddenField")
    public void setId(final int id) {
        this.id = id;
    }
}
