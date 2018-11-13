package com.hy.app.company.news.service;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hy.app.company.news.dao.INewsDao;
import com.hy.app.company.news.entity.News;
import com.hy.app.company.news.entity.NewsParam;
import com.hy.app.company.news.entity.NewsVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author machao
 * @version 1.0
 * @date 16/6/29
 * @company lzh
 * @copyright copyright(c) 2015~2016
 */
@Service("NewsService")
public class NewsService implements INewsService {

    private static final Logger logger = LoggerFactory.getLogger(NewsService.class);
    @Resource(name = "INewsDao")
    private INewsDao newsDao;

    @Override
    public News queryNewsById(long newsId) {
        News news= newsDao.queryNewsById(newsId);
        logger.info(JSON.toJSONString(news));
        return news;
    }

    @Override
    public NewsVO queryNewses(NewsParam newsParam) {
        NewsVO response = new NewsVO();
        //按每天统计
        int pageNum = 10000000;
        int pageIndex = 1;
        if(newsParam.getIDisplayLength() != 0) {
            pageNum = newsParam.getIDisplayLength();
            pageIndex = newsParam.getIDisplayStart();
        }
        logger.info("pageIndex:{},pageNum:{}",pageIndex,pageNum);
        PageHelper.startPage(pageIndex, pageNum);
        Page<News> newses = newsDao.queryNewsList(newsParam);

        response.setAaData(newses);
        response.setITotalRecords((int) newses.getTotal());
        response.setITotalPages(newses.getPages());
        return response;
    }
}
