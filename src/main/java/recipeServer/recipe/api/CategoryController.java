package recipeServer.recipe.api;

import org.springframework.web.bind.annotation.PostMapping;
import recipeServer.recipe.service.CategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

  CategoryService categoryService;

  public CategoryController(CategoryService categoryService) {
    this.categoryService = categoryService;
  }

  @GetMapping
  public List<String> getAllCategories() {
    return categoryService.getAllCategories();
  }

  @PostMapping
    public String addCategory(String category) {
        return categoryService.addCategory(category);
    }
}
