package com.warehouse.manager.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * <p>
 * 
 * </p>
 *
 * @author lemndo
 * @since 2022-09-16
 */
@Data
@TableName("c_goods")
@ApiModel(value = "Goods对象", description = "")
public class Goods implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("货物名")
    @ExcelProperty("货名")
    private String goodsName;

    @ApiModelProperty("库存")
    @ExcelProperty("库存")
    private Integer size;

    @ApiModelProperty("位置")
    @ExcelProperty("位置")
    private String location;

    @ApiModelProperty("类型")
    @ExcelProperty("类型")
    private String type;

    @ApiModelProperty("描述")
    @ExcelProperty("描述")
    private String translate;

    @ApiModelProperty("上次更新时间")
    @ExcelProperty("更新时间")
    private String lastTime;
}