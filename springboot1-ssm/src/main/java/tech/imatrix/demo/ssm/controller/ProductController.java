package tech.imatrix.demo.ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import tech.imatrix.demo.ssm.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("list")
    public String list(){
        return "product/list";
    }

    @GetMapping("input")
    public String input(){
        return "product/input";
    }
}
