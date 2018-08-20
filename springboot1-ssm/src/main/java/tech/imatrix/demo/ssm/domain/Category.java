package tech.imatrix.demo.ssm.domain;

import javax.persistence.*;
import java.util.List;

@Table(name = "ssm_category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private Long id;

    private String name;

    @Column(name = "display_order")
    private Integer displayOrder;

    private List<Product> products;

    public List<Product> getProducts() {
        return products;
    }

    public Category(){}
    public Category(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

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
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * @return display_order
     */
    public Integer getDisplayOrder() {
        return displayOrder;
    }

    /**
     * @param displayOrder
     */
    public void setDisplayOrder(Integer displayOrder) {
        this.displayOrder = displayOrder;
    }
}