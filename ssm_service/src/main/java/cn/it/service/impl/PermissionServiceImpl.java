package cn.it.service.impl;

import cn.it.dao.IPermissionDao;
import cn.it.domain.Permission;
import cn.it.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PermissionServiceImpl implements IPermissionService {

    @Autowired
    private IPermissionDao pd;


    @Override
    public List<Permission> findAll() {
        return pd.findAll();
    }

    @Override
    public Permission findById(String id) {
        return pd.findById(id);
    }

    @Override
    public void deletePermission(String id) {
        pd.deletePermission(id);
        pd.deleteRole_Permission(id);
    }

    @Override
    public void save(Permission permission) {
        permission.setId(UUID.randomUUID().toString().replace("-",""));
        pd.save(permission);
    }
}
