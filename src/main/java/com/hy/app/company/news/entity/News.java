package com.hy.app.company.news.entity;

import com.alibaba.fastjson.JSON;
import com.hy.app.common.util.DateUtil;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * News类
 * @author machao
 * @version 1.0
 * @date 2017/11/30
 * @company lzh
 * @category com.hy.app.company.news.entity
 * @copyright copyright(c) 2016~2017
 */
@Setter
@Getter
public class News implements Serializable {
    /**
     * id
     */
    private long newsId;
    /**
     * 名称
     */
    private String newsName;
    /**
     * 描述
     */
    private String newsTitle;
    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 创建时间描述
     */
    private String createTimeDesc;
    /**
     * 富文本
     */
    private String newsContent;
    /**
     * 分享图片
     */
    private String shareImg;

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
        if (createTime!=null){
            this.createTimeDesc=DateUtil.timeMillis4FormatStr(createTime.getTime(),DateUtil.YYYY_MM_DD_HH_MM);
        }
    }
    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
