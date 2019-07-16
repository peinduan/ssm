package cn.it.controller;


import cn.it.domain.Role;
import cn.it.service.IRoleService;
import cn.it.utils.Href;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private IRoleService rs;

    @RequestMapping("/findAll")
    public ModelAndView findAll(){
        return Href.go("roleList",rs.findAll(),"role-list");
    }

    @RequestMapping("/save")
    public String save(Role role){
        rs.save(role);
        return "forward:findAll";
    }

    @RequestMapping("/findById")
    public ModelAndView findById(String id){
        Role role=rs.findById(id);
        return Href.go("role",role,"role-show");
    }

    @RequestMapping("/deleteRole")
    public String deleteRole(String id){
        rs.deleteRole(id);
        return "forward:findAll";
    }

    @RequestMapping("/findRoleByIdAndAllPermission")
    public ModelAndView findRoleByIdAndAllPermission(String id){
        return Href.go("role",rs.findRoleByIdAndAllPermission(id),"role-permission-add");
    }

    @RequestMapping("/addPermissionToRole")
    public String addPermissionToRole(String[] ids,String roleId){
        if (ids!=null&&ids.length>0)
        rs.addPermissionToRole(ids,roleId);
        return "forward:findAll";
    }
}
