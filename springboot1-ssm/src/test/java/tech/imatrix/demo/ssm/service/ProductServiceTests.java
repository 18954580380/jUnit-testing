package tech.imatrix.demo.ssm.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import tech.imatrix.demo.ssm.domain.Product;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceTests {
    @Autowired
    ProductService productService;

    @Test
    @Sql({"/scripts/category-schema.sql", "/scripts/product-schema.sql","/scripts/category-data.sql","/scripts/product-data.sql"})
    public void testListByPage(){
        List<Product> products = productService.listByPage();
       // assertThat(products.size(), is(4));
        assertThat(products.size()).isEqualTo(4);
    }
}
