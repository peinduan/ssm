package cn.it.dao;

import cn.it.domain.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IRoleDao {


    @Select("SELECT role.*\n" +
            "FROM role,users_role\n" +
            "WHERE role.`id` = users_role.`roleid` AND users_role.`userid`=#{id}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(column = "rolename", property = "roleName"),
            @Result(column = "roledesc", property = "roleDesc"),
            @Result(column = "id",property = "permissions",javaType = List.class,
                    many = @Many(select = "cn.it.dao.IPermissionDao.findPermissionByRoleId"))
    })
    Role findRoleByUserId(String id);

    @Select("SELECT * FROM role WHERE id NOT IN (\n" +
            "SELECT role.id\n" +
            "FROM role,users_role\n" +
            "WHERE role.`id` = users_role.`roleid` AND users_role.`userid`=#{id})")
    Role findRoleNotHaveByUserId(String id);


    @Select("select * from role")
    List<Role> findAll();

    @Insert("insert into role values(#{id},#{roleName},#{roleDesc})")
    void save(Role role);

    @Select("select * from role where id = #{id}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(column = "rolename", property = "roleName"),
            @Result(column = "roledesc", property = "roleDesc"),
            @Result(column = "id",property = "permissions",javaType = List.class,
                    many = @Many(select = "cn.it.dao.IPermissionDao.findPermissionByRoleId"))
    })
    Role findById(String id);


    @Delete("DELETE FROM role WHERE id=#{id}")
    void deleteRole(String id);


    @Delete("DELETE FROM role_permission WHERE roleid=#{id}")
    void deleteRole_Permission(String id);

    @Select("select * from role where id = #{id}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(column = "rolename", property = "roleName"),
            @Result(column = "roledesc", property = "roleDesc"),
            @Result(column = "id",property = "permissions",javaType = List.class,
                    many = @Many(select = "cn.it.dao.IPermissionDao.findRoleByIdAndPermissionNotHave"))
    })
    Role findRoleByIdAndPermissionNotHave(String id);


    @Insert("insert into role_permission values(#{id},#{roleId})")
    void addPermissionToRole(@Param("id") String id,@Param("roleId") String roleId);
}
