package org.example.todo.category;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import todo.category.Category;
import todo.category.CategoryRepository;
import todo.category.CategoryService;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class CategoryUnitTest {
    @Mock
    private CategoryRepository categoryRepository;


    @InjectMocks
    private CategoryService categoryService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindAllCategory() {
        Category category = new Category();
        category.setName("Baking");
        when(categoryRepository.findAll()).thenReturn(Collections.singletonList(category));

        List<Category> result = categoryService.getAllCategories();

        verify(categoryRepository, times(1)).findAll();
        assertEquals(1, result.size());
        assertEquals("Baking", result.get(0).getName());
    }

    @Test
    void testAddCategory() {
        Category category = new Category();
        category.setName("Testing");
        categoryService.saveCategory(category);

        verify(categoryRepository, times(1)).save(any(Category.class));
    }

    @Test
    void testUpdateCategory() {
        Category changer = new Category();
        changer.setName("test1");
        changer.setId(4);
        Category newChange = changer;
        newChange.setName("test2");

        when(categoryRepository.findById(4)).thenReturn(Optional.of(changer));

        categoryService.updateCategory(newChange);

        verify(categoryRepository, times(1)).save(newChange);
        verify(categoryRepository, times(1)).findById(4);
        assertEquals(changer.getName(), newChange.getName());
    }

    @Test
    void testDeleteEmployeeByLastname() {
        Category category = new Category();
        category.setName("delting");
        category.setId(4);

        when(categoryRepository.findById(4)).thenReturn(Optional.of(category));

        categoryService.deleteCategoryById(4);

        verify(categoryRepository, times(1)).findById(4);
        verify(categoryRepository, times(1)).delete(category);
    }
}
