package com.warehouse.manager.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.warehouse.manager.entity.OutLog;
import com.warehouse.manager.mapper.OutLogMapper;
import com.warehouse.manager.service.IOutLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.warehouse.manager.util.ro.PageIn;
import com.warehouse.manager.util.vo.OutVo;
import com.warehouse.manager.util.vo.PageOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lemndo
 * @since 2022-09-21
 */
@Service
public class OutLogServiceImpl extends ServiceImpl<OutLogMapper, OutLog> implements IOutLogService {

    @Autowired
    private IOutLogService outLogService;

    @Override
    public PageOut getOutLogLists(PageIn pageIn) {
        Integer pageNo = pageIn.getCurrPage();
        Integer pageSize = pageIn.getPageSize();
        IPage<OutLog> page = new Page<>(pageNo, pageSize);
        QueryWrapper<OutLog> queryWrapper = new QueryWrapper<>();
        //搜素关键字，并且按照id逆序排列
        queryWrapper.and(wrapper -> wrapper.like("goods_name", pageIn.getKeyword()).or().like("type", pageIn.getKeyword()).or().like("out_user", pageIn.getKeyword()));
        queryWrapper.orderByDesc("id");
        OutLog outLog = new OutLog();
        queryWrapper.setEntity(outLog);

        IPage<OutLog> list = outLogService.page(page, queryWrapper);

        List<OutVo> outVo = new ArrayList<>();
        for (OutLog outLog1 : list.getRecords()) {
            OutVo out = new OutVo();
            BeanUtil.copyProperties(outLog1, out);
            outVo.add(out);
        }

        // 自定义分页返回对象
        PageOut pageOut = new PageOut();
        pageOut.setList(outVo);
        pageOut.setTotal((int) list.getTotal());
        pageOut.setCurrPage((int) list.getCurrent());
        pageOut.setPageSize((int) list.getSize());
        return pageOut;
    }
}
