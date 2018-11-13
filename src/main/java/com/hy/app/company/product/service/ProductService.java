package com.hy.app.company.product.service;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hy.app.company.product.dao.IProductDao;
import com.hy.app.company.product.entity.Product;
import com.hy.app.company.product.entity.ProductImg;
import com.hy.app.company.product.entity.ProductImgVO;
import com.hy.app.company.product.entity.ProductParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author machao
 * @version 1.0
 * @date 16/6/29
 * @company lzh
 * @copyright copyright(c) 2015~2016
 */
@Service("ProductService")
public class ProductService implements IProductService {

    private static final Logger logger = LoggerFactory.getLogger(ProductService.class);
    @Resource(name = "IProductDao")
    private IProductDao productDao;


    @Override
    public List<Product> queryProducts() {
        List<Product> datas = productDao.queryProducts();
        logger.info(JSON.toJSONString(datas));
        return datas;
    }

    @Override
    public Product queryProductById(long productId) {
        Product product= productDao.queryProductById(productId);
        logger.info(JSON.toJSONString(product));
        return product;
    }

    @Override
    public ProductImgVO queryProductImgs(ProductParam productParam) {
        ProductImgVO response = new ProductImgVO();
        //按每天统计
        int pageNum = 10000000;
        int pageIndex = 1;
        if(productParam.getIDisplayLength() != 0) {
            pageNum = productParam.getIDisplayLength();
            pageIndex = productParam.getIDisplayStart();
        }
        logger.info("pageIndex:{},pageNum:{}",pageIndex,pageNum);
        PageHelper.startPage(pageIndex, pageNum);
        Page<ProductImg> productImgs = productDao.queryProductImgs(productParam);

        response.setAaData(productImgs);
        response.setITotalRecords((int) productImgs.getTotal());
        response.setITotalPages(productImgs.getPages());
        return response;
    }
}
