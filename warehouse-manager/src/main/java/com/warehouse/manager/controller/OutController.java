package com.warehouse.manager.controller;


import com.warehouse.manager.service.IGoodsService;
import com.warehouse.manager.service.IOutService;
import com.warehouse.manager.util.R;
import com.warehouse.manager.util.consts.Constants;
import com.warehouse.manager.util.http.CodeEnum;
import com.warehouse.manager.util.vo.OutVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lemndo
 * @since 2022-10-21
 */
@Api(tags = "出库管理")
@Controller
@RestController
@RequestMapping("/out")
public class OutController {
    @Autowired
    private IOutService outService;


    @Autowired
    private IGoodsService goodsService;

    @ApiOperation("出库货物")
    @PostMapping("/add")
    public R addOut(@RequestBody OutVo out) {
        Integer result = outService.addOut(out);
        if (result == Constants.GOODS_SIZE_NOT_ENOUGH) {
            return R.success(CodeEnum.BOOK_NOT_ENOUGH);
        }
        return R.success(CodeEnum.SUCCESS,Constants.OK);
    }
}

