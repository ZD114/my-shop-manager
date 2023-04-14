package com.zhangda.config;

import com.zhangda.service.ShopRoleService;
import com.zhangda.service.ShopUserService;
import com.zhangda.shiro.AuthRealm;
import com.zhangda.shiro.CustomCredentialsMatcher;
import com.zhangda.shiro.MyShiroFilterFactoryBean;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.LinkedHashMap;

/**
 * @author zhangda
 * @date: 2023/4/10
 **/
@Configuration
public class ShiroConfig {
    @DubboReference
    private ShopUserService shopUserService;

    @DubboReference
    private ShopRoleService shopRoleService;

    // 1.创建 realm 对象,需要自定义类当前类
    @Bean(name = "authRealm")
    AuthRealm authRealm() {
        return new AuthRealm(shopUserService, shopRoleService);
    }

    // 2.密码比较
    @Bean(name = "customCredentialsMatcher")
    CustomCredentialsMatcher customCredentialsMatcher() {
        return new CustomCredentialsMatcher();
    }

    // 3.session配置
    @Bean(name = "sessionManager")
    DefaultWebSessionManager sessionManager() {
        var defaultWebSessionManager = new DefaultWebSessionManager();
        // 会话过期时间
        defaultWebSessionManager.setGlobalSessionTimeout(1000 * 60 * 30);
        defaultWebSessionManager.setSessionValidationInterval(1000 * 60 * 30);
        defaultWebSessionManager.setDeleteInvalidSessions(true);
        defaultWebSessionManager.setSessionValidationSchedulerEnabled(true);
        defaultWebSessionManager.setSessionIdCookieEnabled(true);
        // tomcat的JESSIONID自动生成模块
        defaultWebSessionManager.setSessionIdUrlRewritingEnabled(false);
        return defaultWebSessionManager;
    }

    // 4.安全管理器配置
    @Bean(name = "securityManager")
    DefaultWebSecurityManager defaultWebSecurityManager(@Qualifier("authRealm") AuthRealm authRealm,
                                                        @Qualifier("customCredentialsMatcher") CustomCredentialsMatcher customCredentialsMatcher,
                                                        @Qualifier("sessionManager") DefaultWebSessionManager sessionManager) {
        var manager = new DefaultWebSecurityManager();
        // 密码校验放入域中
        authRealm.setCredentialsMatcher(customCredentialsMatcher);
        authRealm.setAuthenticationCachingEnabled(true); // 开启认证缓存
        authRealm.setAuthorizationCachingEnabled(true); // 开启授权缓存
        // 将域添加到安全管理器中
        manager.setRealm(authRealm);
        // 设置session管理器
        manager.setSessionManager(sessionManager);

        return manager;
    }

    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(
            @Qualifier("securityManager") DefaultWebSecurityManager securityManager) {
        var shiroFilterFactoryBean = new MyShiroFilterFactoryBean();
        // 创建安全管理器
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        shiroFilterFactoryBean.setLoginUrl("/login");
        shiroFilterFactoryBean.setSuccessUrl("/");

        var filterMap = new LinkedHashMap<String, Filter>();

        shiroFilterFactoryBean.setFilters(filterMap);

        var filterChainDefinitionMap = new LinkedHashMap<String, String>();

        filterChainDefinitionMap.put("/login*", "anon");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);

        return shiroFilterFactoryBean;
    }
}
