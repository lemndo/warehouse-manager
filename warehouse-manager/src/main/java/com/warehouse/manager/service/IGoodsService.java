package com.warehouse.manager.service;

import com.warehouse.manager.entity.Goods;
import com.baomidou.mybatisplus.extension.service.IService;
import com.warehouse.manager.util.ro.PageIn;
import com.warehouse.manager.util.vo.GoodsOut;
import com.warehouse.manager.util.vo.PageOut;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lemndo
 * @since 2022-09-16
 */
public interface IGoodsService extends IService<Goods> {


    PageOut getGoodsLists(PageIn pageIn);

    GoodsOut findGoodsById(Integer id);
}
