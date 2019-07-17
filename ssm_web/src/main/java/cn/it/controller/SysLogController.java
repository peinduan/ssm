package cn.it.controller;


import cn.it.service.ISysService;
import cn.it.utils.Href;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("sysLog")
public class SysLogController {

    @Autowired
    private ISysService ss;

    @RequestMapping("findAll")
    public ModelAndView findAll(@RequestParam(name = "page", required = true, defaultValue = "1") Integer page,
                                @RequestParam(name = "size", required = true, defaultValue = "4") Integer size){
        return Href.go("pageInfo",ss.findAll(page,size),"syslog-list");

    }
}
