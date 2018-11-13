package com.hy.app.company.news.controller;

import com.hy.app.company.news.service.INewsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * @author machao
 * @version 1.0
 * @date 2016/11/21
 * @company lzh
 * @copyright copyright(c) 2015~2016
 */
@Controller
@RequestMapping("news")
public class NewsController {
    // log4j
    private static final Logger logger = LoggerFactory.getLogger(NewsController.class);
    @Resource(name = "NewsService")
    private INewsService newsService;

    @RequestMapping("/index")
    public ModelAndView index() {
        ModelAndView mav = new ModelAndView("/index");
//        IndexResponse response = indexService.queryIndexDatas();
//        mav.addObject("visits", response.getVisits());
        return mav;
    }
}
