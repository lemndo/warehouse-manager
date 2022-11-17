package com.warehouse.manager.service;

import com.warehouse.manager.entity.Out;
import com.baomidou.mybatisplus.extension.service.IService;
import com.warehouse.manager.util.vo.OutVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lemndo
 * @since 2022-10-21
 */
public interface IOutService extends IService<Out> {

    Integer addOut(OutVo out);
}
