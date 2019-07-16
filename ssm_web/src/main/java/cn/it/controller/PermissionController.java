package cn.it.controller;


import cn.it.domain.Permission;
import cn.it.service.IPermissionService;
import cn.it.utils.Href;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/permission")
public class PermissionController {

    @Autowired
    private IPermissionService ps;

    @RequestMapping("findAll")
    public ModelAndView findAll(){
        return Href.go("permissionList",ps.findAll(),"permission-list");
    }

    @RequestMapping("findById")
    public ModelAndView findById(String id){
        return Href.go("permission",ps.findById(id),"permission-show");
    }

    @RequestMapping("deletePermission")
    public String deletePermission(String id){
        ps.deletePermission(id);
        return "forward:findAll";
    }

    @RequestMapping("save")
    public String save(Permission permission){
        ps.save(permission);
        return "forward:findAll";
    }
}
