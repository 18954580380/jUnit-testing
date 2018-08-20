package tech.imatrix.demo.ssm.service;

import tech.imatrix.demo.ssm.domain.Category;

import java.util.List;

public interface CategoryService {
    Category getCategory(Long id);
    void saveCategory(Category category);
    void deleteCategory(Long id);
    List<Category> listByPage();
}
