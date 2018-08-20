package tech.imatrix.demo.ssm.service;

import tech.imatrix.demo.ssm.domain.OrderItem;

import java.util.List;

public interface OrderItemService {
    OrderItem getOrderItem(Long id);
    void saveOrderItem(OrderItem orderItem);
    void deleteOrderItem(Long id);
    List<OrderItem> listByPage();
}
