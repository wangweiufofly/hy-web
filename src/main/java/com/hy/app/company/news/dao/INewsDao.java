package com.hy.app.company.news.dao;

import com.github.pagehelper.Page;
import com.hy.app.company.news.entity.News;
import com.hy.app.company.news.entity.NewsParam;

/**
 * @author machao
 * @version 1.0
 * @date 16/5/16
 * @company lzh
 * @copyright copyright(c) 2015~2016
 */
public interface INewsDao {

    /**
     * 查询
     *
     * @return
     */
    News queryNewsById(long newsId);
    /**
     * 查询
     *
     * @return
     */
    Page<News> queryNewsList(NewsParam newsParam);

    /**
     * 插入
     *
     * @param News
     * @return
     */
    int insertNews(News News);

    /**
     * 删除
     *
     * @param News
     * @return
     */
    int deleteNews(News News);
}
