package com.warehouse.manager.util.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 货物出参对象
 */
@Data
public class GoodsOut {

    @ApiModelProperty("货物ID")
    private Integer id;

    @ApiModelProperty("货物名")
    private String name;

    @ApiModelProperty("库存")
    private Integer size;

    @ApiModelProperty("位置")
    private String location;

    @ApiModelProperty("类型")
    private String type;

    @ApiModelProperty("描述")
    private String translate;

    @ApiModelProperty("更新时间")
    private String lastTime;
}
