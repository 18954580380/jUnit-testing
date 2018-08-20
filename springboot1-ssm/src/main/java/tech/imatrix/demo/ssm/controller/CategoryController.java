package tech.imatrix.demo.ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.imatrix.demo.ssm.service.CategoryService;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("list")
    public String list(){
        return "category/list";
    }

    @GetMapping("input")
    public String input(){
        return "category/input";
    }

    @GetMapping("test")
    public String test(){
        return "Hello！";
    }
}
