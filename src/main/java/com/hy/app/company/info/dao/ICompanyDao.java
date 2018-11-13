package com.hy.app.company.info.dao;

import com.hy.app.company.info.entity.Company;

import java.util.List;

/**
 * @author machao
 * @version 1.0
 * @date 16/5/16
 * @company lzh
 * @copyright copyright(c) 2015~2016
 */
public interface ICompanyDao {
    /**
     * 插入
     *
     * @param company
     * @return
     */
    int insertCompany(Company company);

    /**
     * 删除
     *
     * @param company
     * @return
     */
    int deleteCompany(Company company);
    /**
     * 查询
     *
     * @param companyId
     * @return
     */
    Company queryCompanyById(long companyId);
}
