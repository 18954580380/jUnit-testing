package tech.imatrix.demo.ssm.dao;

import tech.imatrix.demo.ssm.domain.Product;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface ProductMapper extends Mapper<Product> {
    List<Product> listByPage();
}