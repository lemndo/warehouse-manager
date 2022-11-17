package com.warehouse.manager.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.sql.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 * 
 * </p>
 *
 * @author lemndo
 * @since 2022-09-21
 */
@TableName("c_out_log")
@ApiModel(value = "OutLog对象", description = "")
@Data
public class OutLog implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String name;

    private Integer goodsId;

    private Integer outSize;

    private String type;

    private Date outTime;

    private String outUser;

    private String confirmUser;

    private String memo;


}
