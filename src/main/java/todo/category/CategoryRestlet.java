package todo.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;


import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing categories.
 */
@RestController
@RequestMapping("/api/category")
public final class CategoryRestlet {
    /**
     * Service for categories.
     */
    @Autowired
    private CategoryService categoryService;

    /**
     * Retrieves all categories.
     *
     * @return a list of categories
     */
    @GetMapping
    public List<Category> getAllCategory() {
        return categoryService.getAllCategories();
    }

    /**
     * Adds a new category.
     *
     * @param category the category to add
     * @return the added category
     */
    @PostMapping
    public Category addCategory(@RequestBody final Category category) {
        return categoryService.saveCategory(category);
    }

    /**
     * Deletes a category by its ID.
     *
     * @param id the category ID
     */
    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable final int id) {
        categoryService.deleteCategoryById(id);
    }

    /**
     * Updates an existing category.
     *
     * @param id the category ID
     * @param category the category to update
     * @return the updated category
     */
    @PutMapping("/{id}")
    public Category updateCategory(@PathVariable final int id, @RequestBody final Category category) {

        Optional<Category> existingCategory = categoryService.getCategoryById(id);

        if (existingCategory.isPresent()) {
            Category updatedCategory = existingCategory.get();
            updatedCategory.setName(category.getName());
            return categoryService.updateCategory(updatedCategory);
        } else {
            throw new NullPointerException("Category not found");
        }
    }
}
