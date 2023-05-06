package com.zhangda.common.es.service;

import java.io.IOException;
import java.util.List;

/**
 * @description:
 * @auther: zd
 * @date: 2023/5/6
 **/
public interface EsBaseService {

    /**
     * Index不存在时创建
     *
     * @param index 参数
     * @throws IOException 异常
     */
    void noExistsCreateIndex(String index) throws IOException;

    /**
     * 批量删除 Index
     *
     * @param index  参数
     * @param idList 结果
     */
    void batchDelete(String index, List<Integer> idList);
}
