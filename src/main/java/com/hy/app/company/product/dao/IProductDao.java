package com.hy.app.company.product.dao;

import com.github.pagehelper.Page;
import com.hy.app.company.product.entity.Product;
import com.hy.app.company.product.entity.ProductImg;
import com.hy.app.company.product.entity.ProductParam;

import java.util.List;

/**
 * @author machao
 * @version 1.0
 * @date 16/5/16
 * @company lzh
 * @copyright copyright(c) 2015~2016
 */
public interface IProductDao {
    /**
     * 查询
     *
     * @return
     */
    List<Product> queryProducts();

    /**
     * 查询
     *
     * @return
     */
    Product queryProductById(long productId);
    /**
     * 查询
     *
     * @return
     */
    Page<ProductImg> queryProductImgs(ProductParam productParam);

    /**
     * 插入
     *
     * @param Product
     * @return
     */
    int insertProduct(Product Product);

    /**
     * 删除
     *
     * @param Product
     * @return
     */
    int deleteProduct(Product Product);
}
