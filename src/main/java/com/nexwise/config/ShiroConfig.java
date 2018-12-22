package com.nexwise.config;

import com.nexwise.entity.realm.CustomRealm;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;

/**
 * @Descript shiro配置类
 * @Author fuyuanming
 * @Date 2018-07-05 17:29:57
 * @Version 1.0
 */
@Configuration
public class ShiroConfig {

    /**
     * 注册自定义Realm
     * @return
     */
    @Bean(name = "customRealm")
    public CustomRealm customRealm() {
        return new CustomRealm();
    }

    /**
     * 注册shiro安全管理器
     * @return
     */
    @Bean
    public SecurityManager securityManager(@Qualifier("customRealm")CustomRealm customRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //设置Realm
        securityManager.setRealm(customRealm);
        return securityManager;
    }

    /**
     * 注册shiro安全过滤器
     * @return
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(@Qualifier("customRealm")CustomRealm customRealm) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(new ShiroConfig().securityManager(customRealm));
        shiroFilterFactoryBean.setLoginUrl("/login");
        shiroFilterFactoryBean.setSuccessUrl("/index");
        LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
        map.put("/user/**","anon");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
        return shiroFilterFactoryBean;
    }
}
