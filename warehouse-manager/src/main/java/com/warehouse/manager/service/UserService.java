package com.warehouse.manager.service;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.warehouse.manager.mapper.UsersMapper;
import com.warehouse.manager.entity.Users;
import com.warehouse.manager.repos.UsersRepository;
import com.warehouse.manager.util.ro.PageIn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @Description 用户业务类
 * @Date 2020/7/14 16:31
 * @Author by 尘心
 */
@Service
public class UserService implements UserDetailsService{

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private UsersMapper usersMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;


    /**
     * 添加用户
     * @param users 用户
     * @return 返回添加的用户
     */
    public Users addUser(Users users) {
        return usersRepository.saveAndFlush(users);
    }

    /**
     * 编辑用户
     * @param users 用户对象
     * @return true or false
     */
    @Transactional(rollbackFor = Exception.class)
    public boolean updateUser(Users users) {
        return usersMapper.updateUsers(BeanUtil.beanToMap(users))>0;
    }

    /**
     * 用户详情
     * @param id 主键
     * @return 用户详情
     */
    public Users findUserById(Integer id) {
        Optional<Users> optional = usersRepository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        }
        return null;
    }

    /**
     * 删除用户
     * @param id 主键
     * @return true or false
     */
    public void deleteUser(Integer id) {
        usersRepository.deleteById(id);
    }


    /**
     * 用户搜索查询(mybatis 分页)
     * @param pageIn
     * @return
     */
    public IPage<Users> getUserList(PageIn pageIn) {

//        PageHelper.startPage(pageIn.getCurrPage(),pageIn.getPageSize());
        QueryWrapper<Users> wrapper = new QueryWrapper();
        Page<Users> page = new Page<>(pageIn.getCurrPage(),pageIn.getPageSize());

        IPage<Users> mapIPage = usersMapper.selectPage(page,wrapper);
//        List<Users> listByLike = usersMapper.findListByLike(pageIn.getKeyword());
        return mapIPage;
    }

    /**
     * 用户鉴权
     * @param username 用户名
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 查找用户
        Users user = usersRepository.findByUsername(username);
        // 获得角色
        String role = String.valueOf(user.getIsAdmin());
        // 角色集合
        List<GrantedAuthority> authorities = new ArrayList<>();
        // 角色必须以`ROLE_`开头，数据库中没有，则在这里加
        authorities.add(new SimpleGrantedAuthority("ROLE_" + role));
        // 数据库密码是明文, 需要加密进行比对
        return new User(user.getUsername(), passwordEncoder.encode(user.getPassword()), authorities);
    }

    /**
     * 用户名查询用户信息
     * @param username 用户名
     */
    public Users findByUsername(String username) {
        return usersRepository.findByUsername(username);
    }
}