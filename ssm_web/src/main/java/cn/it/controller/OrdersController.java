package cn.it.controller;


import cn.it.domain.Orders;
import cn.it.service.IOrdersService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private IOrdersService os;

    /*@RequestMapping("/findAll")
    public ModelAndView findAll(){
        ModelAndView modelAndView = new ModelAndView();
        List<Orders> list = os.findAll();
        modelAndView.addObject("ordersList",list);
        modelAndView.setViewName("orders-list");
        return modelAndView;
    }*/

    @RequestMapping("/findAll")
    public ModelAndView findAll(@RequestParam(name = "page", required = true, defaultValue = "1") int page,
                                @RequestParam(name = "size", required = true, defaultValue = "4") int size) {
        ModelAndView modelAndView = new ModelAndView();
        List<Orders> list = os.findAll(page, size);
        PageInfo<Orders> info = new PageInfo<>(list);
        modelAndView.addObject("pageInfo", info);
        modelAndView.setViewName("orders-page-list");
        return modelAndView;
    }

    @RequestMapping("/findById")
    public ModelAndView findById(@RequestParam(name = "id", required = true) String id) {
        ModelAndView modelAndView = new ModelAndView();
        Orders orders = os.findById(id);
        modelAndView.addObject("orders",orders);
        modelAndView.setViewName("orders-show");
        return modelAndView;
    }

}
