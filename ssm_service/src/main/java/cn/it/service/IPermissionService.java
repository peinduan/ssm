package cn.it.service;

import cn.it.domain.Permission;

import java.util.List;

public interface IPermissionService {
    List<Permission> findAll();

    Permission findById(String id);

    void deletePermission(String id);

    void save(Permission permission);

}
