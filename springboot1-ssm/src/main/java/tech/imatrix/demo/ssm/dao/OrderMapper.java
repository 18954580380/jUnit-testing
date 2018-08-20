package tech.imatrix.demo.ssm.dao;

import tech.imatrix.demo.ssm.domain.Order;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface OrderMapper extends Mapper<Order> {
    List<Order> getOrdersOfUser(Long userId);
}