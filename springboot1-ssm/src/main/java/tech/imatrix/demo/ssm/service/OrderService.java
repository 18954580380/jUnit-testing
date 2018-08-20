package tech.imatrix.demo.ssm.service;

import tech.imatrix.demo.ssm.domain.Order;

import java.util.List;

public interface OrderService {
    Order getOrder(Long id);
    void saveOrder(Order order);
    void deleteOrder(Long id);
    List<Order> listByPage();
    List<Order> getOrdersOfUser(Long userId);
    void createOrder(Order order);
}
