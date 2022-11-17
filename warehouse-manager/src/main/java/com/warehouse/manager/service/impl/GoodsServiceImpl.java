package com.warehouse.manager.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.warehouse.manager.entity.Goods;
import com.warehouse.manager.mapper.GoodsMapper;
import com.warehouse.manager.repos.GoodsRepository;
import com.warehouse.manager.service.IGoodsService;
import com.warehouse.manager.util.ro.PageIn;
import com.warehouse.manager.util.vo.GoodsOut;
import com.warehouse.manager.util.vo.PageOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author lemndo
 * @since 2022-09-16
 */
@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements IGoodsService {

    @Autowired
    private GoodsRepository goodsRepository;

    @Autowired
    private GoodsMapper goodsMapper;

    @Autowired
    private IGoodsService goodsService;

    /**
     * 货物搜索查询(mybatis 分页)
     *
     * @param pageIn
     * @return
     */

    @Override
    public PageOut getGoodsLists(PageIn pageIn) {
        //获取前台发送过来的数据
        Integer pageNo = pageIn.getCurrPage();
        Integer pageSize = pageIn.getPageSize();
        IPage<Goods> page = new Page<>(pageNo, pageSize);
        QueryWrapper<Goods> queryWrapper = new QueryWrapper<>();
        queryWrapper.and(wrapper -> wrapper.like("name", pageIn.getKeyword()).or().like("type", pageIn.getKeyword()));
        Goods goods = new Goods();
        queryWrapper.setEntity(goods);

        IPage<Goods> list = goodsService.page(page, queryWrapper);

        List<GoodsOut> goodsOuts = new ArrayList<>();
        for (Goods good : list.getRecords()) {
            GoodsOut out = new GoodsOut();
            BeanUtil.copyProperties(good, out);
//            out.setLastTime(DateUtil.format(good.getLastTime(), "yyyy-MM-dd"));
            goodsOuts.add(out);
        }

        // 自定义分页返回对象
        PageOut pageOut = new PageOut();
        pageOut.setList(goodsOuts);
        pageOut.setTotal((int) list.getTotal());
        pageOut.setCurrPage((int) list.getCurrent());
        pageOut.setPageSize((int) list.getSize());
        return pageOut;
    }

    /**
     * 图书详情
     *
     * @param id 主键
     * @return 图书详情
     */
    @Override
    public GoodsOut findGoodsById(Integer id) {
        Goods goods = goodsMapper.selectById(id);
        if (goods != null) {
            System.out.println("通过id找到货物！");
            GoodsOut out = new GoodsOut();
            BeanUtil.copyProperties(goods, out);
            return out;
        }

        return null;
    }
}
