package com.hy.app.company.info.service;

import com.hy.app.company.info.entity.Company;

/**
 * @author machao
 * @version 1.0
 * @date 16/5/16
 * @company lzh
 * @copyright copyright(c) 2015~2016
 */
public interface ICompanyService {
    /**
     * 查询公司信息
     * @return
     */
    Company queryCompanyById(long companyId);

}
