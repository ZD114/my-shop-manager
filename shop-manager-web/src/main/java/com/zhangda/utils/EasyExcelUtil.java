package com.zhangda.utils;

import com.alibaba.excel.EasyExcelFactory;
import com.zhangda.common.Constant;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

/**
 * excel操作管理
 *
 * @author zhangda
 * @date: 2023/2/23
 **/
public class EasyExcelUtil {

    private EasyExcelUtil() {
    }

    /**
     * excel导出
     *
     * @param response
     * @param fileName
     * @param list
     */
    public static void downloadExcel(HttpServletResponse response, String fileName, List<?> list, Class<?> object) {
        // 设置下载信息
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding(Constant.UTF8);

        try {
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8") + ".xlsx");
            EasyExcelFactory.write(response.getOutputStream(), object).sheet(fileName).doWrite(list);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
