package com.cskt.zxh.goodsdemo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
@author zxh
@date 2021/11/17 -- 18:13
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "goods")
public class Goods {
    /**
     * 商品编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 商品名称
     */
    @TableField(value = "goodsName")
    private String goodsname;

    /**
     * 订单状态
     */
    @TableField(value = "billStatus")
    private Integer billstatus;

    /**
     * 订单区域
     */
    @TableField(value = "goodsDistrict")
    private Integer goodsdistrict;

    /**
     * 商品价格
     */
    @TableField(value = "goodsPrice")
    private Double goodsprice;

    /**
     * 商品数量
     */
    @TableField(value = "goodsCount")
    private Long goodscount;

    /**
     * 创建时间
     */
    @TableField(value = "creationTime")
    private Date creationtime;
}