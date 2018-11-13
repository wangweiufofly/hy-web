package com.hy.app.company.banner.service;

import com.alibaba.fastjson.JSON;
import com.hy.app.company.banner.dao.IBannerDao;
import com.hy.app.company.banner.entity.Banner;
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
@Service("BannerService")
public class BannerService implements IBannerService {

    private static final Logger bannerLog = LoggerFactory.getLogger(BannerService.class);
    @Resource(name = "IBannerDao")
    private IBannerDao bannerDao;

    @Override
    public List<Banner> queryBanners() {
        List<Banner> datas = bannerDao.queryBanners();
        bannerLog.info(JSON.toJSONString(datas));
        return datas;
    }
}
