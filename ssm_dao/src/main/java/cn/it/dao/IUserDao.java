package cn.it.dao;

import cn.it.domain.Role;
import cn.it.domain.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IUserDao {

    @Select("select * from users where username = #{username}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(column = "username", property = "username"),
            @Result(column = "email", property = "email"),
            @Result(column = "password", property = "password"),
            @Result(column = "phoneNum", property = "phoneNum"),
            @Result(column = "status", property = "status"),
            @Result(column = "id",property = "roles",javaType = List.class,
                    many = @Many(select = "cn.it.dao.IRoleDao.findRoleByUserId"))
    })
    UserInfo findUserByUsername(String username);



    @Select("select * from users")
    List<UserInfo> findAll();


    @Insert("insert into users values(#{id},#{email},#{username},#{password},#{phoneNum},#{status})")
    void save(UserInfo userInfo);


    @Select("select * from users where id = #{id}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(column = "username", property = "username"),
            @Result(column = "email", property = "email"),
            @Result(column = "password", property = "password"),
            @Result(column = "phoneNum", property = "phoneNum"),
            @Result(column = "status", property = "status"),
            @Result(column = "id",property = "roles",javaType = List.class,
                    many = @Many(select = "cn.it.dao.IRoleDao.findRoleByUserId"))
    })
    UserInfo findById(String id);


    @Select("select * from users where id = #{id}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(column = "username", property = "username"),
            @Result(column = "email", property = "email"),
            @Result(column = "password", property = "password"),
            @Result(column = "phoneNum", property = "phoneNum"),
            @Result(column = "status", property = "status"),
            @Result(column = "id",property = "roles",javaType = List.class,
                    many = @Many(select = "cn.it.dao.IRoleDao.findRoleNotHaveByUserId"))
    })
    UserInfo findUserByIdAndAllRole(String id);



    @Insert("insert into users_role values(#{userId},#{id})")
    void saveRoles(@Param("id") String id,@Param("userId") String userId);
}
