package tech.imatrix.demo.ssm.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import tech.imatrix.demo.ssm.domain.User;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTests {
    @Autowired
    UserService userService;

    @Test
    @Sql({"/scripts/user-schema.sql","/scripts/user-data.sql"})
    public void testGetUser(){
        User user = userService.getUser(1L);
        assertThat(user.getLoginname(), is("admin"));
    }
}
