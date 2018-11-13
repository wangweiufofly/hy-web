package com.hy.app.company.product.entity;

import com.alibaba.fastjson.JSON;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * ProductParam
 * @author machao
 * @version 1.0
 * @date 2017/11/30
 * @company lzh
 * @category com.hy.app.company.product.entity
 * @copyright copyright(c) 2016~2017
 */
@Setter
@Getter
public class ProductParam extends Product {

    private int iDisplayStart = 1;

    private int iDisplayLength = 9;

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
