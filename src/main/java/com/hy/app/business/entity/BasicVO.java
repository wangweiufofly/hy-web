package com.hy.app.business.entity;

import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author yeling
 * @version 1.0
 * @date 15/8/28
 * @company lzh
 * @category com.hy.app.business.entity
 * @copyright copyright(c) 2018~2019
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BasicVO implements Serializable {

    /**
     * 返回码
     */
    private int result = 1;
    /**
     * 错误信息
     */
    private String error;

    public String toJSONString() {
        return JSON.toJSONString(this);
    }
}
