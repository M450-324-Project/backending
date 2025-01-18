package todo.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/category")
public class CategoryRestlet {
    CategoryService categoryService;

    public CategoryRestlet(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("")
     public List<Category> getAllCategory() {
        return categoryService.getAllCategories();
    }

    @PostMapping("")
    public Category addCategory(@RequestBody Category category) {
        return categoryService.saveCategory(category);
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable int id) {
        categoryService.deleteCategoryById(id);
    }

    @PutMapping("/{id}")
    public Category updateCategory(@PathVariable int id, @RequestBody Category category) {
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
