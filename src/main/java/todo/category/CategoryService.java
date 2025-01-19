package todo.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service class for managing categories.
 */
@Service
public final class CategoryService {

    /**
     * Repository for categories.
     */
    @Autowired
    private CategoryRepository categoryRepository;

    /**
     * Retrieves all categories.
     *
     * @return a list of categories
     */
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    /**
     * Retrieves a category by its ID.
     *
     * @param id the category ID
     * @return the category
     */
    public Optional<Category> getCategoryById(final int id) {
        return categoryRepository.findById(id);
    }

    /**
     * Saves a new category.
     *
     * @param category the category to save
     * @return the saved category
     */
    public Category saveCategory(final Category category) {
        return categoryRepository.save(category);
    }

    /**
     * Deletes a category by its ID.
     *
     * @param id the category ID
     */
    public void deleteCategoryById(final int id) {
        categoryRepository.deleteById(id);
    }

    /**
     * Updates an existing category.
     *
     * @param newCategory the new category data
     * @return the updated category
     */
    public Category updateCategory(final Category newCategory) {
        return categoryRepository.save(newCategory);
    }
}
