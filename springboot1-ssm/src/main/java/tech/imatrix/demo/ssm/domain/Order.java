package tech.imatrix.demo.ssm.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Table(name = "ssm_order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private Long id;

    @Column(name = "order_number")
    private String orderNumber;

    @Column(name = "created_date")
    private Date createdDate;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "total_price")
    private Double totalPrice;

    private User user;

    public Order(){

    }
    public Order(Long id, Long userId) {
        this.id = id;
        this.userId = userId;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    private List<OrderItem> orderItems;
    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return order_number
     */
    public String getOrderNumber() {
        return orderNumber;
    }

    /**
     * @param orderNumber
     */
    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    /**
     * @return created_date
     */
    public Date getCreatedDate() {
        return createdDate;
    }

    /**
     * @param createdDate
     */
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    /**
     * @return user_id
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * @return total_price
     */
    public Double getTotalPrice() {
        return totalPrice;
    }

    /**
     * @param totalPrice
     */
    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }
}