package cn.it.dao;

import cn.it.domain.Role;
import org.apache.ibatis.annotations.Select;

public interface IRoleDao {


    @Select("SELECT role.*\n" +
            "FROM role,users_role\n" +
            "WHERE role.`id` = users_role.`roleid` AND users_role.`userid`=#{id}")
    Role findRoleByUserId(String id);
}
