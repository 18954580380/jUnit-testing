package tech.imatrix.demo.ssm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.imatrix.demo.ssm.dao.ProductMapper;
import tech.imatrix.demo.ssm.domain.Product;
import tech.imatrix.demo.ssm.service.ProductService;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;

    @Override
    public Product getProduct(Long id) {
        return productMapper.selectByPrimaryKey(id);
    }

    @Override
    public void saveProduct(Product product) {
        if(product.getId()==null){
            productMapper.insert(product);
        }else{
            productMapper.updateByPrimaryKeySelective(product);
        }
    }

    @Override
    public void deleteProduct(Long id) {
        productMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Product> listByPage() {
        return productMapper.listByPage();
    }
}
