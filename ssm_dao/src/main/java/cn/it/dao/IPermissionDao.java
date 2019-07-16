package cn.it.dao;

import cn.it.domain.Permission;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IPermissionDao {


    @Select("SELECT permission.*\n" +
            "FROM permission,role_permission\n" +
            "WHERE permission.`id`=role_permission.`permissionid` AND role_permission.`roleid`=#{id}")
    List<Permission> findPermissionByRoleId(String id);

    @Select("SELECT * FROM permission WHERE id NOT IN (\n" +
            "SELECT permission.`id`\n" +
            "FROM permission,role_permission\n" +
            "WHERE permission.`id`=role_permission.`permissionid` AND role_permission.`roleid`=#{id})")
    List<Permission> findRoleByIdAndPermissionNotHave(String id);
}
