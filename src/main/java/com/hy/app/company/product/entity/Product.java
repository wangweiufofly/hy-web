package com.hy.app.company.product.entity;

import com.alibaba.fastjson.JSON;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * banner类
 * @author machao
 * @version 1.0
 * @date 2017/11/30
 * @company lzh
 * @category com.hy.app.company.product.entity
 * @copyright copyright(c) 2016~2017
 */
@Setter
@Getter
public class Product implements Serializable {
    /**
     * id
     */
    private long productId;
    /**
     * 名称
     */
    private String productName;
    /**
     * 描述
     */
    private String productDesc;
    /**
     * 描述
     */
    private String imgSrc;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 图片数
     */
    private int imgNum;

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
