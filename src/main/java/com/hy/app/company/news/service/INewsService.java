package com.hy.app.company.news.service;

import com.hy.app.company.news.entity.News;
import com.hy.app.company.news.entity.NewsParam;
import com.hy.app.company.news.entity.NewsVO;

/**
 * @author machao
 * @version 1.0
 * @date 16/5/16
 * @company lzh
 * @category com.lzhplus.app.data.manager.service
 * @copyright copyright(c) 2015~2016
 */
public interface INewsService {
    /**
     *
     * @param newsId
     * @return
     */
    News queryNewsById(long newsId);

    /**
     *
     * @param newsParam
     * @return
     */
    NewsVO queryNewses(NewsParam newsParam);

}
