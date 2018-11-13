package com.hy.app.business.controller;

import com.alibaba.fastjson.JSON;
import com.hy.app.business.entity.MenuVO;
import com.hy.app.company.banner.entity.Banner;
import com.hy.app.company.banner.service.IBannerService;
import com.hy.app.company.info.entity.Company;
import com.hy.app.company.info.service.ICompanyService;
import com.hy.app.company.news.entity.NewsParam;
import com.hy.app.company.news.entity.NewsVO;
import com.hy.app.company.news.service.INewsService;
import com.hy.app.company.product.entity.Product;
import com.hy.app.company.product.entity.ProductImgVO;
import com.hy.app.company.product.entity.ProductParam;
import com.hy.app.company.product.service.IProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author machao
 * @version 1.0
 * @date 2016/11/21
 * @company lzh
 * @copyright copyright(c) 2015~2016
 */
@Controller
@RequestMapping("")
public class IndexController {
    // log4j
    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);
    @Resource(name = "BannerService")
    private IBannerService bannerService;

    @Resource(name = "CompanyService")
    private ICompanyService companyService;

    @Resource(name = "ProductService")
    private IProductService productService;

    @Resource(name = "NewsService")
    private INewsService newsService;

    @RequestMapping({"/index",""})
    public String index(Model model) {
        List<Banner> banners = bannerService.queryBanners();
        model.addAttribute("banners", banners);
        List<Product> products = productService.queryProducts();
        model.addAttribute("products", products);
        logger.info(JSON.toJSONString(banners));
        return "company/index";
    }

    @RequestMapping("/product")
    public String product(@ModelAttribute Product product, Model model) {
        List<Product> products = productService.queryProducts();
        long productId = product.getProductId();
        String productName = null;
        if (productId == 0 && products.size()>0){
            productId = products.get(0).getProductId();
            productName = products.get(0).getProductName();
        }
        if (productId != 0){
            ProductParam productParam = new ProductParam();
            productParam.setProductId(productId);
            ProductImgVO response = productService.queryProductImgs(productParam);
            model.addAttribute("productImgs", response.getAaData());
            if (StringUtils.isEmpty(productName)){
                for (Product item: products) {
                    if (item.getProductId() == productId){
                        productName = item.getProductName();
                        break;
                    }
                }
            }
            model.addAttribute("productId", productId);
            model.addAttribute("productName", productName);
            model.addAttribute("iTotalPages", response.getITotalPages());
        }else{
            model.addAttribute("productImgs", new ArrayList());
            model.addAttribute("iTotalPages", 0);
        }
        model.addAttribute("products", products);
        return "company/product";
    }

    @RequestMapping("/queryMenuInfo")
    @ResponseBody
    public MenuVO queryMenuInfo() {
        MenuVO response = new MenuVO();
        List<Product> products = productService.queryProducts();
        long companyId=1000001;
        Company company = companyService.queryCompanyById(companyId);
        response.setProducts(products);
        response.setCompany(company);
        return response;
    }

    @RequestMapping("/queryProductImgs")
    @ResponseBody
    public ProductImgVO queryProductImgs(ProductParam productParam) {
        ProductImgVO response = productService.queryProductImgs(productParam);
        return response;
    }


    @RequestMapping("/contactUS")
    public String contactUS(Model model) {
        long companyId=1000001;
        Company company = companyService.queryCompanyById(companyId);
        model.addAttribute("company", company);
        return "company/contactUS";
    }

    @RequestMapping("/news")
    public String news(Model model) {
        NewsParam newsParam = new NewsParam();
        NewsVO response = newsService.queryNewses(newsParam);
        model.addAttribute("newses", response.getAaData());
        model.addAttribute("iTotalPages", response.getITotalPages());
        return "company/news";
    }
    @RequestMapping("/queryNewses")
    @ResponseBody
    public NewsVO queryNewses(NewsParam newsParam) {
        NewsVO response = newsService.queryNewses(newsParam);
        return response;
    }
}
