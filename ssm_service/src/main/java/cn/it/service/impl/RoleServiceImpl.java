package cn.it.service.impl;

import cn.it.dao.IRoleDao;
import cn.it.domain.Role;
import cn.it.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private IRoleDao rd;

    @Override
    public List<Role> findAll() {
        return rd.findAll();
    }

    @Override
    public void save(Role role) {
        role.setId(UUID.randomUUID().toString().replace("-",""));
        rd.save(role);
    }

    @Override
    public Role findById(String id) {
        return rd.findById(id);
    }

    @Override
    public void deleteRole(String id) {
        rd.deleteRole(id);
        rd.deleteRole_Permission(id);
    }

    @Override
    public Role findRoleByIdAndAllPermission(String id) {
        return rd.findRoleByIdAndPermissionNotHave(id);
    }

    @Override
    public void addPermissionToRole(String[] ids, String roleId) {
        for (String id : ids) {
            rd.addPermissionToRole(id,roleId);

        }
    }
}
