package cn.it.service;

import cn.it.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IUserService extends UserDetailsService {

    List<UserInfo> findAll();

    void save(UserInfo userInfo);

    UserInfo findById(String id);

    UserInfo findUserByIdAndAllRole(String id);

    void addRoles(String[] ids, String userId);
}
