package com.hy.app.common.interceptor;

/**
 * @author machao
 * @version 1.0
 * @date 2017/4/24
 * @company lzh
 * @category com.hy.app.common.interceptor
 * @copyright copyright(c) 2016~2017
 */
public class URLEncoderTest {
    public static void main(String[] args) throws Exception{
        String redirectReturn = "http://bi.laozihaojia.com/data/user/reportView?viewId=首页";

        String abc = java.net.URLEncoder.encode(redirectReturn,"UTF-8");

        System.out.println(abc);

        System.out.println(java.net.URLDecoder.decode(abc,"UTF-8"));
    }
}
