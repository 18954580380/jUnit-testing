package tech.imatrix.demo.ssm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.imatrix.demo.ssm.dao.CategoryMapper;
import tech.imatrix.demo.ssm.domain.Category;
import tech.imatrix.demo.ssm.service.CategoryService;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public Category getCategory(Long id) {
        return categoryMapper.selectByPrimaryKey(id);
    }

    @Override
    public void saveCategory(Category category) {
        if(category.getId()==null){
            categoryMapper.insert(category);
        }else{
            categoryMapper.updateByPrimaryKeySelective(category);
        }
    }

    @Override
    public void deleteCategory(Long id) {
        categoryMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Category> listByPage() {
        return categoryMapper.selectAll();
    }
}
