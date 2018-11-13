package com.hy.app.company.info.entity;

import com.alibaba.fastjson.JSON;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * company类
 * @author machao
 * @version 1.0
 * @date 2017/11/30
 * @company lzh
 * @category com.hy.app.company.company.entity
 * @copyright copyright(c) 2016~2017
 */
@Setter
@Getter
public class Company implements Serializable {

    /**
     * id
     */
    private long companyId;
    /**
     * 名称
     */
    private String companyName;
    /**
     * 描述
     */
    private String companyTitle;
    /**
     * 介绍
     */
    private String introduction;
    /**
     * 地址
     */
    private String address;
    /**
     * 电话
     */
    private String phoneJson;
    /**
     * qq
     */
    private long qq;
    /**
     * 微信号
     */
    private String webchat;
    /**
     * 地图名片
     */
    private String mapCard;
    /**
     * 图片
     */
    private String imgSrc;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 创建时间
     */
    private Date createTime;

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
