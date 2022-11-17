package com.warehouse.manager.service;

import com.warehouse.manager.entity.OutLog;
import com.baomidou.mybatisplus.extension.service.IService;
import com.warehouse.manager.util.ro.PageIn;
import com.warehouse.manager.util.vo.PageOut;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lemndo
 * @since 2022-09-21
 */
public interface IOutLogService extends IService<OutLog> {

    PageOut getOutLogLists(PageIn pageIn);
}
