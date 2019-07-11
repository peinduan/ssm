package cn.it.controller;


import cn.it.domain.Product;
import cn.it.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService ps;

    @RequestMapping("/findAll")
    public ModelAndView findAll(){
        ModelAndView modelAndView = new ModelAndView();
        List<Product> list = ps.findAll();
        modelAndView.addObject("productList", list);
        System.out.println(list);
        modelAndView.setViewName("product-list1");
        return modelAndView;
    }
}
