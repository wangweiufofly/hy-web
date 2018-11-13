package com.hy.app.company.product.service;

import com.hy.app.company.product.entity.Product;
import com.hy.app.company.product.entity.ProductImgVO;
import com.hy.app.company.product.entity.ProductParam;

import java.util.List;

/**
 * @author machao
 * @version 1.0
 * @date 16/5/16
 * @company lzh
 * @category com.lzhplus.app.data.manager.service
 * @copyright copyright(c) 2015~2016
 */
public interface IProductService {
    /**
     *
     * @return
     */
    List<Product> queryProducts();

    /**
     *
     * @param productId
     * @return
     */
    Product queryProductById(long productId);

    /**
     *
     * @param productParam
     * @return
     */
    ProductImgVO queryProductImgs(ProductParam productParam);

}
