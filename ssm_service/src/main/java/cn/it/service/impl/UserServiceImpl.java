package cn.it.service.impl;

import cn.it.dao.IUserDao;
import cn.it.domain.Role;
import cn.it.domain.UserInfo;
import cn.it.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;


@Service("iUserService")
public class UserServiceImpl implements IUserService {

    @Autowired
    private PasswordEncoder pe;

    @Autowired
    private IUserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo user = userDao.findUserByUsername(username);
        System.out.println(user);
        if (user==null) return null;
        return new User(user.getUsername(),"{noop}"+user.getPassword(),user.getStatus()==1,
                true,true,true,
                getAuthorities(user.getRoles()));

    }

    private Collection<SimpleGrantedAuthority> getAuthorities(List<Role> roles) {
        ArrayList<SimpleGrantedAuthority> list = new ArrayList<>();
        for (Role role : roles) {
            list.add(new SimpleGrantedAuthority("ROLE_"+role.getRoleName()));
        }
        return list;
    }


    @Override
    public List<UserInfo> findAll() {
        return userDao.findAll();
    }

    @Override
    public void save(UserInfo userInfo) {
        userInfo.setId(UUID.randomUUID().toString().replace("-",""));
        userInfo.setPassword(pe.encode(userInfo.getPassword()));
        userDao.save(userInfo);
    }

    @Override
    public UserInfo findById(String id) {
        return userDao.findById(id);
    }

    @Override
    public UserInfo findUserByIdAndAllRole(String id) {
        return userDao.findUserByIdAndAllRole(id);
    }

    @Override
    public void addRoles(String[] ids, String userId) {
        for (String id : ids) {
            userDao.saveRoles(id,userId);
        }
    }
}
