package com.hy.app.company.news.entity;


import com.hy.app.business.entity.BasicVO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author machao
 * @version 1.0
 * @date 2017/11/24
 * @company lzh
 * @category com.hy.app.company.news.entity
 * @copyright copyright(c) 2016~2017
 */
@Getter
@Setter
public class NewsVO extends BasicVO {
    private int iTotalRecords;

    private int iTotalPages;

    private List<News> aaData;
}
