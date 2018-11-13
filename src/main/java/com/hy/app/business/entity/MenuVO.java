package com.hy.app.business.entity;

import com.hy.app.company.info.entity.Company;
import com.hy.app.company.product.entity.Product;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author yeling
 * @version 1.0
 * @date 15/8/28
 * @company lzh
 * @category com.hy.app.business.entity
 * @copyright copyright(c) 2018~2019
 */
@Getter
@Setter
public class MenuVO extends BasicVO {

    private List<Product> products;
    private Company company;
}
