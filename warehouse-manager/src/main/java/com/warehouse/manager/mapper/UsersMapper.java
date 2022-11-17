package com.warehouse.manager.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.warehouse.manager.entity.Users;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Date 2020/7/14 19:57
 * @Author by 尘心
 */
@Mapper
@Component
public interface UsersMapper extends BaseMapper<Users> {

    /**
     * 模糊分页查询用户
     * @param keyword 关键字
     * @return
     */
    List<Users> findListByLike(String keyword);

    /**
     * 编辑用户
     * @param map
     * @return
     */
    int updateUsers(Map<String,Object> map);
}
