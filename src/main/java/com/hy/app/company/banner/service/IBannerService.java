package com.hy.app.company.banner.service;

import com.hy.app.company.banner.entity.Banner;

import java.util.List;

/**
 * @author machao
 * @version 1.0
 * @date 16/5/16
 * @company lzh
 * @copyright copyright(c) 2015~2016
 */
public interface IBannerService {
    /**
     *
     * @return
     */
     List<Banner> queryBanners();

}
