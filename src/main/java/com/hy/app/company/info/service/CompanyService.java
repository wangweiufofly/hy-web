package com.hy.app.company.info.service;

import com.alibaba.fastjson.JSON;
import com.hy.app.company.info.dao.ICompanyDao;
import com.hy.app.company.info.entity.Company;
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
@Service("CompanyService")
public class CompanyService implements ICompanyService {

    private static final Logger companyLog = LoggerFactory.getLogger(CompanyService.class);
    @Resource(name = "ICompanyDao")
    private ICompanyDao companyDao;

    @Override
    public Company queryCompanyById(long companyId) {
        Company company = companyDao.queryCompanyById(companyId);
        companyLog.info(JSON.toJSONString(company));
        return company;
    }
}
