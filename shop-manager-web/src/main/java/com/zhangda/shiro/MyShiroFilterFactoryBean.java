package com.zhangda.shiro;

import com.zhangda.shiro.servlet.MyShiroHttpServletResponse;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.filter.mgt.FilterChainResolver;
import org.apache.shiro.web.filter.mgt.PathMatchingFilterChainResolver;
import org.apache.shiro.web.mgt.WebSecurityManager;
import org.apache.shiro.web.servlet.AbstractShiroFilter;
import org.apache.shiro.web.servlet.ShiroHttpServletRequest;
import org.springframework.beans.factory.BeanInitializationException;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义Shiro过滤
 *
 * @author zhangda
 * @date: 2023/4/10
 **/
public class MyShiroFilterFactoryBean extends ShiroFilterFactoryBean {
    private SecurityManager securityManager;

    public SecurityManager getSecurityManager() {
        return securityManager;
    }

    public void setSecurityManager(SecurityManager securityManager) {
        this.securityManager = securityManager;
    }

    @SuppressWarnings("rawtypes")
    @Override
    public Class getObjectType() {
        return MySpringShiroFilter.class;
    }

    @Override
    protected AbstractShiroFilter createInstance() throws Exception {

        var securityManager = (SecurityManager) getSecurityManager();

        if (securityManager == null) {
            var msg = "SecurityManager property must be set.";
            throw new BeanInitializationException(msg);
        }

        if (!(securityManager instanceof WebSecurityManager)) {
            var msg = "The security manager does not implement the WebSecurityManager interface.";
            throw new BeanInitializationException(msg);
        }

        var manager = createFilterChainManager();

        var chainResolver = new PathMatchingFilterChainResolver();
        chainResolver.setFilterChainManager(manager);

        return new MySpringShiroFilter((WebSecurityManager) securityManager,
                chainResolver);
    }

    private static final class MySpringShiroFilter extends AbstractShiroFilter {

        protected MySpringShiroFilter(WebSecurityManager webSecurityManager,
                                      FilterChainResolver resolver) {
            super();
            if (webSecurityManager == null) {
                throw new IllegalArgumentException(
                        "WebSecurityManager property cannot be null.");
            }
            setSecurityManager(webSecurityManager);
            if (resolver != null) {
                setFilterChainResolver(resolver);
            }
        }

        @Override
        protected ServletResponse wrapServletResponse(HttpServletResponse orig,
                                                      ShiroHttpServletRequest request) {
            return new MyShiroHttpServletResponse(orig, getServletContext(),
                    request);
        }
    }
}
