package recipeServer.recipe.service;

import recipeServer.recipe.entity.Category;
import recipeServer.recipe.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

  CategoryRepository categoryRepository;

  public CategoryService(CategoryRepository categoryRepository) {
    this.categoryRepository = categoryRepository;
  }

  public List<String> getAllCategories() {
    List<Category> categories =  categoryRepository.findAll();
    //Convert from list of Categories to DTO-type, list of Strings
    return categories.stream().map((c)->new String(c.getName())).toList();
  }

  public String addCategory(String categoryName) {
    Category newCategory = new Category(categoryName);
    categoryRepository.save(newCategory);
    return newCategory.getName()+" added";
  }
}
