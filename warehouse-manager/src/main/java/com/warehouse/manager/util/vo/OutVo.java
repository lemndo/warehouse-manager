package com.warehouse.manager.util.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.sql.Date;


/**
 * 出库货物出参对象
 */
@Data
public class OutVo {

    @ApiModelProperty("id")
    private Integer id;

    @ApiModelProperty("货物ID")
    private Integer goodsId;

    @ApiModelProperty("货物名")
    private String goodsName;

    @ApiModelProperty("出库数量")
    private Integer outSize;

    @ApiModelProperty("货物分类")
    private String type;

    @ApiModelProperty("出库时间")
    private Date outTime;

    @ApiModelProperty("经办人")
    private String confirmUser;

    @ApiModelProperty("出库人")
    private String outUser;

    @ApiModelProperty("备注")
    private String memo;
}
