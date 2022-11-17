package com.warehouse.manager.controller;


import com.warehouse.manager.service.IOutLogService;
import com.warehouse.manager.util.R;
import com.warehouse.manager.util.http.CodeEnum;
import com.warehouse.manager.util.ro.PageIn;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lemndo
 * @since 2022-09-21
 */
@Controller
@Api(tags = "货物出库记录")
@RestController
@RequestMapping("/outLog")
public class OutLogController {
    @Autowired
    private IOutLogService outLogService;

    @ApiOperation("出库记录搜索列表")
    @PostMapping("/list")
    public R getGoodsLists(@RequestBody PageIn pageIn) {
        if (pageIn == null) {
            return R.fail(CodeEnum.PARAM_ERROR);
        }

        return R.success(CodeEnum.SUCCESS,outLogService.getOutLogLists(pageIn));
    }

    @ApiOperation("删除记录")
    @GetMapping("del")
    public R delRecord(Integer id) {
        System.out.println("id:"+id);
        outLogService.removeById(id);
        return R.success(CodeEnum.SUCCESS);
    }
}