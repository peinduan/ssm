package cn.it.controller;


import cn.it.domain.Orders;
import cn.it.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private IOrdersService os;

    @RequestMapping("/findAll")
    public ModelAndView findAll(){
        ModelAndView modelAndView = new ModelAndView();
        List<Orders> list = os.findAll();
        modelAndView.addObject("ordersList",list);
        modelAndView.setViewName("orders-list");
        return modelAndView;
    }
}
