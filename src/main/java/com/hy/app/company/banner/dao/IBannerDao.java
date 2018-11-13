package com.hy.app.company.banner.dao;

import com.hy.app.company.banner.entity.Banner;

import java.util.List;

/**
 * @author machao
 * @version 1.0
 * @date 16/5/16
 * @company lzh
 * @copyright copyright(c) 2015~2016
 */
public interface IBannerDao {
    /**
     * 查询
     *
     * @return
     */
    List<Banner> queryBanners();

    /**
     * 插入
     *
     * @param banner
     * @return
     */
    int insertBanner(Banner banner);

    /**
     * 删除
     *
     * @param banner
     * @return
     */
    int deleteBanner(Banner banner);
}
