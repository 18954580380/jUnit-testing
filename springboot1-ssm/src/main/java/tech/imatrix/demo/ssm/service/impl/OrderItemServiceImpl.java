package tech.imatrix.demo.ssm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.imatrix.demo.ssm.dao.OrderItemMapper;
import tech.imatrix.demo.ssm.domain.OrderItem;
import tech.imatrix.demo.ssm.service.OrderItemService;

import java.util.List;

@Service
@Transactional
public class OrderItemServiceImpl implements OrderItemService {

    @Autowired
    private OrderItemMapper orderItemMapper;

    @Override
    public OrderItem getOrderItem(Long id) {
        return orderItemMapper.selectByPrimaryKey(id);
    }

    @Override
    public void saveOrderItem(OrderItem orderItem) {
        if(orderItem.getId()!=null){
            orderItemMapper.updateByPrimaryKey(orderItem);
        }else{
            orderItemMapper.insert(orderItem);
        }
    }

    @Override
    public void deleteOrderItem(Long id) {
        orderItemMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<OrderItem> listByPage() {
        return orderItemMapper.selectAll();
    }
}
