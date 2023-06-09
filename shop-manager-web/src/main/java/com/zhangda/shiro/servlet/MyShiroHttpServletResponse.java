package com.zhangda.shiro.servlet;

import org.apache.shiro.web.servlet.ShiroHttpServletRequest;
import org.apache.shiro.web.servlet.ShiroHttpServletResponse;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

/**
 * @author zhangda
 * @date: 2023/4/10
 **/
public class MyShiroHttpServletResponse extends ShiroHttpServletResponse {
    public MyShiroHttpServletResponse(HttpServletResponse wrapped, ServletContext context, ShiroHttpServletRequest request) {
        super(wrapped, context, request);
    }

    @Override
    protected String toEncoded(String url, String sessionId) {
        if ((url == null) || (sessionId == null))
            return (url);

        var path = url;
        var query = "";
        var anchor = "";
        var question = url.indexOf('?');

        if (question >= 0) {
            path = url.substring(0, question);
            query = url.substring(question);
        }
        int pound = path.indexOf('#');
        if (pound >= 0) {
            anchor = path.substring(pound);
            path = path.substring(0, pound);
        }
        var sb = new StringBuilder(path);

        sb.append(anchor);
        sb.append(query);
        return (sb.toString());
    }
}
