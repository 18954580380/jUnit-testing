package tech.imatrix.demo.ssm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.imatrix.demo.ssm.dao.OrderMapper;
import tech.imatrix.demo.ssm.domain.Order;
import tech.imatrix.demo.ssm.domain.OrderItem;
import tech.imatrix.demo.ssm.domain.Product;
import tech.imatrix.demo.ssm.service.OrderItemService;
import tech.imatrix.demo.ssm.service.OrderService;
import tech.imatrix.demo.ssm.service.ProductService;

import java.util.List;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private ProductService productService;

    @Autowired
    private OrderItemService orderItemService;

    @Override
    public Order getOrder(Long id) {
        return orderMapper.selectByPrimaryKey(id);
    }

    @Override
    public void saveOrder(Order order) {
        if(order.getId()!=null){
            orderMapper.updateByPrimaryKey(order);
        }else{
            orderMapper.insert(order);
        }
    }

    @Override
    public void deleteOrder(Long id) {
        orderMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Order> listByPage() {
        return orderMapper.selectAll();
    }

    @Override
    public List<Order> getOrdersOfUser(Long userId) {
        return orderMapper.getOrdersOfUser(userId);
    }

    @Override
    public void createOrder(Order order) {
        if(order.getOrderItems()==null||order.getOrderItems().isEmpty()){
            throw new RuntimeException("没有购买商品！不能创建订单。");
        }
        //判断库存是否够，如果够就扣减库存
        for(OrderItem orderItem: order.getOrderItems()){
            Product product = productService.getProduct(orderItem.getProductId());
            if(orderItem.getAmount()<=product.getAmount()){
                product.setAmount(product.getAmount()-orderItem.getAmount());
                productService.saveProduct(product);
            }else{
                throw new RuntimeException(product.getName()+"库存不足！");
            }
        }
        //保存订单和订单项
        saveOrder(order);
        for(OrderItem orderItem: order.getOrderItems()){
            orderItemService.saveOrderItem(orderItem);
        }
    }
}
