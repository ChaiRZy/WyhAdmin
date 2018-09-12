package com.feri.wyh10000.admin.shiro;

import com.feri.wyh10000.admin.realm.AdminRealm;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 *@Author feri
 *@Date Created in 2018/9/12 14:31
 * Spring Boot配置第三方对象
 * @Configuration
 */
@Configuration
public class ShiroConfig {
    //管理器
    @Bean
    public SecurityManager securityManager(AdminRealm adminRealm){
        DefaultWebSecurityManager securityManager=new DefaultWebSecurityManager();
        securityManager.setRealm(adminRealm);
        return securityManager;
    }
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager){
        ShiroFilterFactoryBean filterFactoryBean=new ShiroFilterFactoryBean();
        filterFactoryBean.setSecurityManager(securityManager);
        filterFactoryBean.setLoginUrl("login.html");
        filterFactoryBean.setSuccessUrl("index.html");
        filterFactoryBean.setUnauthorizedUrl("noauth.html");
        Map<String,String> map=new HashMap<>();
        map.put("/login.html","anon");
        map.put("/adminlogin.do","anon");
        map.put("/media/**","anon");
        map.put("/**","authc");
        filterFactoryBean.setFilterChainDefinitionMap(map);

        return filterFactoryBean;
    }
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager){
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor=new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }
//    @Bean
//    public AdminRealm adminRealm(){
//        return new AdminRealm();
//    }

}
