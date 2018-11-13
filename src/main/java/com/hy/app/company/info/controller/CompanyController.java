package com.hy.app.company.info.controller;

import com.hy.app.company.info.service.ICompanyService;
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
@RequestMapping("company")
public class CompanyController {
    // log4j
    private static final Logger dataLog = LoggerFactory.getLogger(CompanyController.class);
    @Resource(name = "CompanyService")
    private ICompanyService companyService;

    @RequestMapping("/index")
    public ModelAndView index() {
        ModelAndView mav = new ModelAndView("/index");
//        IndexResponse response = indexService.queryIndexDatas();
//        mav.addObject("visits", response.getVisits());
        return mav;
    }
}
