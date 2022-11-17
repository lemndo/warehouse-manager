package com.warehouse.manager.controller;


import com.warehouse.manager.entity.Goods;
import com.warehouse.manager.service.IGoodsService;
import com.warehouse.manager.util.DownExcel;
import com.warehouse.manager.util.R;
import com.warehouse.manager.util.http.CodeEnum;
import com.warehouse.manager.util.ro.PageIn;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lemndo
 * @since 2022-09-16
 */
@Controller
@Api(tags = "货物管理")
@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private IGoodsService goodsService;

    @ApiOperation("货物搜索列表")
    @PostMapping("/list")
    public R getGoodsLists(@RequestBody PageIn pageIn) {
        if (pageIn == null) {
            return R.fail(CodeEnum.PARAM_ERROR);
        }

        return R.success(CodeEnum.SUCCESS,goodsService.getGoodsLists(pageIn));
    }

    @ApiOperation("货物详情")
    @GetMapping("/detail")
    public R goodsDetail(Integer id) {
        return R.success(CodeEnum.SUCCESS,goodsService.findGoodsById(id));
    }

    @ApiOperation("编辑货物")
    @PostMapping("/update")
    public R modifyGoods(@RequestBody Goods goods) {
        return R.success(CodeEnum.SUCCESS,goodsService.saveOrUpdate(goods));
    }

    @ApiOperation("删除货物")
    @GetMapping("/delete")
    public R delGoods(Integer id) {
        goodsService.removeById(id);
        return R.success(CodeEnum.SUCCESS);
    }

    @ApiOperation("添加货物")
    @PostMapping("/add")
    public R addGoods(@RequestBody Goods goods) {
        return R.success(CodeEnum.SUCCESS,goodsService.save(goods));
    }


    //导出为Excel
    @ApiOperation("下载")
    @RequestMapping("/downloadexcel.do")
    public void getExcel(HttpServletResponse response) throws IllegalAccessException, IOException, InstantiationException {
        List<Goods> list = goodsService.list();
        DownExcel.download(response,Goods.class,list);
    }

}

