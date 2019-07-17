package cn.it.dao;

import cn.it.domain.Permission;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IPermissionDao {


    @Select("SELECT permission.* FROM permission,role_permission " +
            "WHERE permission.`id`=role_permission.`permissionid` " +
            "AND role_permission.`roleid`=#{id}")
    List<Permission> findPermissionByRoleId(String id);

    @Select("SELECT * FROM permission WHERE id NOT IN (" +
            "SELECT permissionid FROM role_permission WHERE roleid=#{id})")
    List<Permission> findRoleByIdAndPermissionNotHave(String id);


    @Select("select * from Permission")
    List<Permission> findAll();

    @Select("select * from Permission where id = #{id}")
    Permission findById(String id);

    @Delete("DELETE FROM permission WHERE id=#{id}")
    void deletePermission(String id);

    @Delete("DELETE FROM role_permission WHERE permissionid=#{id}")
    void deleteRole_Permission(String id);

    @Insert("insert into permission values(#{id},#{permissionName},#{url})")
    void save(Permission permission);
}
