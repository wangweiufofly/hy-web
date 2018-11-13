package com.hy.app.company.banner.entity;

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
 * @category com.hy.app.company.banner.entity
 * @copyright copyright(c) 2016~2017
 */
@Setter
@Getter
public class Banner implements Serializable {
    /**
     * id
     */
    private long bannerId;
    /**
     * 名称
     */
    private String bannerName;
    /**
     * 描述
     */
    private String bannerTitle;
    /**
     * 图片
     */
    private String imgSrc;
    /**
     * 创建时间
     */
    private Date createTime;

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
