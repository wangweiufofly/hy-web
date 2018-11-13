package com.hy.app.company.news.entity;

import com.alibaba.fastjson.JSON;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * NewsParam
 * @author machao
 * @version 1.0
 * @date 2017/11/30
 * @company lzh
 * @category com.hy.app.company.news.entity
 * @copyright copyright(c) 2016~2017
 */
@Setter
@Getter
@Data
public class NewsParam extends News {

    private int iDisplayStart = 1;

    private int iDisplayLength = 8;

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
