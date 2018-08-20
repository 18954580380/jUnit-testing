package tech.imatrix.demo.ssm.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import tech.imatrix.demo.ssm.domain.User;
import tech.imatrix.demo.ssm.service.UserService;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("list")
    public String list(Integer pageNum, Model model){
        PageHelper.startPage(pageNum, 10);
        List<User> users = userService.listByPage();
        PageInfo<User> pageInfo = new PageInfo<>(users);
        model.addAttribute("pageInfo", pageInfo);
//        int i=1/0;//抛出异常来验证统一错误处理（SpringMVC和ajax都需要处理错误）
        return "user/list";
    }

    @GetMapping("input")
    public String showUserInfo() throws InterruptedException {
//        Thread.sleep(2000);
        return "user/input";
    }

    @GetMapping("select-product")
    public String selectProduct(){
        return "user/select-product";
    }
}
