package cn.it.controller;


import cn.it.domain.UserInfo;
import cn.it.service.IUserService;
import cn.it.utils.Href;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService us;

    @RequestMapping("/findAll")
    public ModelAndView findAll(){
        return Href.go("userList",us.findAll(),"user-list");
    }

    @RequestMapping("/save")
    public String save(UserInfo userInfo){
        us.save(userInfo);
        return "redirect:findAll";

    }


    @RequestMapping("/findById")
    public ModelAndView findById(@RequestParam(name = "id")String id){
        UserInfo userInfo=us.findById(id);
        return Href.go("user",userInfo,"user-show");

    }

    @RequestMapping("/findUserByIdAndAllRole")
    public ModelAndView findUserByIdAndAllRole(@RequestParam(name = "id")String id){
        UserInfo userInfo=us.findUserByIdAndAllRole(id);
        return Href.go("user",userInfo,"user-role-add");

    }

    @RequestMapping("/addRoleToUser")
    public String addRoleToUser(String[] ids,String userId){
        if (ids!=null&&ids.length>0)
        us.addRoles(ids,userId);
        return "redirect:findAll";

    }
}
