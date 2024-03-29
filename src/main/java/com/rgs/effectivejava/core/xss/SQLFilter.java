package com.rgs.effectivejava.core.xss;

import org.apache.commons.lang.StringUtils;

/**
 * SQL过滤
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-04-01 16:16
 */
public class SQLFilter {

    /**
     * SQL注入过滤
     *
     * @param str 待验证的字符串
     * @throws Exception
     */
    public static String sqlInject(String str) throws Exception {
        if(StringUtils.isBlank(str)){
            return null;
        }
        //去掉'|"|;|\字符
        str = StringUtils.replace(str, "'", "");
        str = StringUtils.replace(str, "\"", "");
        str = StringUtils.replace(str, ";", "");
        str = StringUtils.replace(str, "\\", "");

        //转换成小写
        String lowerStr = str.toLowerCase();

        //非法字符
        String[] keywords = {"master", "truncate", "insert", "select", "delete ", "update ", "declare", "alter", "drop"};

        //判断是否包含非法字符
        for(String keyword : keywords){
            if(lowerStr.indexOf(keyword) != -1){
                throw new Exception("包含非法字符");
            }
        }

        return str;
    }
}
