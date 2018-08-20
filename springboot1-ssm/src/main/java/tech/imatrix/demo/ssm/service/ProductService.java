package tech.imatrix.demo.ssm.service;

import tech.imatrix.demo.ssm.domain.Product;

import java.util.List;

public interface ProductService {
    Product getProduct(Long id);
    void saveProduct(Product product);
    void deleteProduct(Long id);
    List<Product> listByPage();
}
