package com.zhangda.service.common;

import java.util.Map;

/**
 * @author zhangda
 * @date: 2023/3/31
 **/
public interface CommonService {
    Integer countLine(String sql, Map<String, Object> params);
}
