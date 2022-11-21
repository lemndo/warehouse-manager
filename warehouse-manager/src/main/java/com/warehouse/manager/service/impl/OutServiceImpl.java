package com.warehouse.manager.service.impl;

import com.warehouse.manager.entity.*;
import com.warehouse.manager.mapper.OutMapper;
import com.warehouse.manager.service.IGoodsService;
import com.warehouse.manager.service.IOutLogService;
import com.warehouse.manager.service.IOutService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.warehouse.manager.service.UserService;
import com.warehouse.manager.util.consts.Constants;
import com.warehouse.manager.util.vo.GoodsOut;
import com.warehouse.manager.util.vo.OutVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lemndo
 * @since 2022-10-21
 */
@Service
@Transactional
public class OutServiceImpl extends ServiceImpl<OutMapper, Out> implements IOutService {

    @Autowired
    private IGoodsService goodsService;

    @Autowired
    private IOutLogService outLogService;

    @Autowired
    private UserService userService;

    @Override
    public Integer addOut(OutVo out) {
        System.out.println("执行addOut！");
        Goods goods = goodsService.getById(out.getGoodsId());

        // 库存数量减一
        int outSize = out.getOutSize();
        int size = goods.getSize();
        if (outSize>0 && outSize <= size) {
            size -= outSize;
            goods.setSize(size);
            System.out.println("更新货物数量！！！");
            goodsService.updateById(goods);

            //增加出库记录
            OutLog outLog = new OutLog();
            outLog.setGoodsId(out.getGoodsId());
            outLog.setGoodsName(goods.getGoodsName());
            outLog.setType(out.getType());
            outLog.setOutSize(outSize);
            outLog.setOutTime(out.getOutTime());
            outLog.setConfirmUser(out.getConfirmUser());
            outLog.setOutUser(out.getOutUser());
            outLog.setMemo(out.getMemo());
            outLogService.save(outLog);
        }else {
            return Constants.GOODS_SIZE_NOT_ENOUGH;
        }

        System.out.println("正常");

        // 一切正常
        return Constants.OK;
    }
}
