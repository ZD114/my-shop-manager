package com.zhangda.common.dao.base;

import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @description:
 * @auther: zd
 * @date: 2023/4/27
 **/
public interface BaseMapper<T> extends Mapper<T>, MySqlMapper<T>, IdsMapper<T> {
}
