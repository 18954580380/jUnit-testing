package tech.imatrix.demo.ssm.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import tech.imatrix.demo.ssm.domain.User;
import tech.imatrix.demo.ssm.service.UserService;

import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

//standalone模式的mockmvc不需要启动web环境，不依赖spring的context，因此必须自己mock service层
//只启动了一个controller
@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerStandaloneTests {
    @MockBean
    private UserService userService;

    @Autowired
    private MockMvc mockMvc;
    /**
     * 在controller中设置了分页参数会保存到ThreadLocal中，这个测试由于mock了service所以最终并没有消费这个分页参数，
     * 这样就会影响其他测试用例的执行，maven的测试是共享一个线程的，后续的service测试会读到这个残留的参数导致错误
     * 因此这里一定要清除干净
     */
    @After
    public void cleanPage(){
        PageHelper.clearPage();
    }
    @Test
    public void testList() throws Exception {
        Page<User> users = new Page<User>(1,10, true);
        users.add(new User(1L,"admin"));
        users.add(new User(2L,"test"));
        users.add(new User(3L,"red"));
        doReturn(users).when(userService).listByPage();
        MvcResult result = mockMvc.perform(get("/user/list").param("pageNum","1"))
                .andExpect(view().name("user/list"))
                .andExpect(model().attributeExists("pageInfo"))
                .andDo(print())
                .andReturn();
    }
}
