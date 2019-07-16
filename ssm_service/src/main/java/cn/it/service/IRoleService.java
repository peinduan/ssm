package cn.it.service;

import cn.it.domain.Role;

import java.util.List;

public interface IRoleService {


    List<Role> findAll();

    void save(Role role);

    Role findById(String id);

    void deleteRole(String id);

    Role findRoleByIdAndAllPermission(String id);

    void addPermissionToRole(String[] ids, String roleId);
}
