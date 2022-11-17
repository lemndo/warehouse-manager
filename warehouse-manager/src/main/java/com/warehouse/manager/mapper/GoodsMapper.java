package com.warehouse.manager.mapper;

import com.warehouse.manager.entity.Goods;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lemndo
 * @since 2022-09-16
 */
@Mapper
@Component
public interface GoodsMapper extends BaseMapper<Goods> {

    /**
     * 模糊分页查询用户
     * @param keyword 关键字
     * @return
     */
    List<Goods> findGoodsListByLike(String keyword);
}
