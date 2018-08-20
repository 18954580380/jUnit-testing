package tech.imatrix.demo.ssm.service;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import tech.imatrix.demo.ssm.domain.Order;
import tech.imatrix.demo.ssm.domain.OrderItem;
import tech.imatrix.demo.ssm.domain.Product;
import tech.imatrix.demo.ssm.domain.User;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderServiceTests {
    @MockBean
    ProductService productService;

    @Autowired
    private OrderService orderService;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    @Sql({"/scripts/user-schema.sql","/scripts/user-data.sql","/scripts/order-schema.sql","/scripts/order-data.sql"})
    public void testGetOrdersOfUser(){
        List<Order> orders = orderService.getOrdersOfUser(1L);
        assertThat(orders.size(),is(2));
    }

    @Test
    @Sql({"/scripts/user-schema.sql","/scripts/user-data.sql","/scripts/order-schema.sql","/scripts/order-item-schema.sql"})
    public void testCreateOrder() throws ParseException {
        Order order = new Order();
        order.setUser(new User(1L, "admin"));
        order.setCreatedDate(DateFormatUtils.ISO_8601_EXTENDED_DATE_FORMAT.parse("2018-08-03"));
        order.setOrderNumber("O-00009");
        order.setTotalPrice(1200d);
        List<OrderItem> orderItems =new ArrayList<>();
        orderItems.add(new OrderItem(1L,1L,10));
        order.setOrderItems(orderItems);

        Product product = new Product(1L,"Konka");
        product.setAmount(15);
//        when(productService.getProduct(1L)).thenReturn(product);
//        doNothing().when(productService).saveProduct(product);

        doReturn(product).when(productService).getProduct(1L);
        orderService.createOrder(order);

        //验证了参数值正确（这个值会传给产品的保存方法）
        assertThat(product.getAmount(), is(5));
        //验证产品保存了：行为验证，而不是验证最后的状态（即数据，数据库中剩余的库存，这个需要使用真实的对象才能做到）
        verify(productService, atLeastOnce()).saveProduct(product);
        //验证订单正确保存了
        assertThat(order.getId(), is(1L));
        //验证订单项也保存了
        assertThat(orderItems.get(0).getId(), is(1L));
    }
    @Test
    public void testCreateOrderWithoutOrderItem() throws ParseException {
        Order order = new Order();
        order.setUser(new User(1L, "admin"));
        order.setCreatedDate(DateFormatUtils.ISO_8601_EXTENDED_DATE_FORMAT.parse("2018-08-03"));
        order.setOrderNumber("O-00009");
        order.setTotalPrice(1200d);
        List<OrderItem> orderItems =new ArrayList<>();
        order.setOrderItems(orderItems);

        //old school老式验证异常的写法
        try{
            orderService.createOrder(order);
            fail();
        }catch (RuntimeException e){
            assertThat(e.getMessage(), is("没有购买商品！不能创建订单。"));
        }
    }
    @Test()
    @Sql({"/scripts/user-schema.sql","/scripts/user-data.sql","/scripts/order-schema.sql","/scripts/order-item-schema.sql"})
    public void testCreateOrderWithoutEnoughProducts() throws ParseException {
        Order order = new Order();
        order.setUser(new User(1L, "admin"));
        order.setCreatedDate(DateFormatUtils.ISO_8601_EXTENDED_DATE_FORMAT.parse("2018-08-03"));
        order.setOrderNumber("O-00009");
        order.setTotalPrice(1200d);
        List<OrderItem> orderItems =new ArrayList<>();
        orderItems.add(new OrderItem(1L,1L,10));
        order.setOrderItems(orderItems);

        //设置库存商品不够
        Product product = new Product(1L,"Konka");
        product.setAmount(5);

        doReturn(product).when(productService).getProduct(1L);

        thrown.expect(RuntimeException.class);
        thrown.expectMessage(is(product.getName()+"库存不足！"));
        //直接在test注解上断言会出现异常，但是没法断言异常信息
        orderService.createOrder(order);
    }

    @Test(expected = ArithmeticException.class)
    public void testDivisionWithException() {
        int i = 1 / 0;
    }

}
