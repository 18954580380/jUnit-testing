package tech.imatrix.demo.ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import tech.imatrix.demo.ssm.service.OrderService;

@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("list")
    public String list(){
        return "order/list";
    }

    @GetMapping("input")
    public String input(){
        return "order/input";
    }
}
