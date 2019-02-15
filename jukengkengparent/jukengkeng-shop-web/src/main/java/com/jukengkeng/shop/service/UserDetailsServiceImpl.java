package com.jukengkeng.shop.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.jukengkeng.pojo.TbSeller;
import com.jukengkeng.sellergoods.service.SellerService;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 认证管理类
 * <p>
 * UserDetails返回了账号、密码、用户
 * Spring Security框架自动会拿用户前端填写的账号密码与返回的账号、密码、用户进行对比，如果通过则跳转到配置页面，如果失败则不进行跳转
 */
public class UserDetailsServiceImpl implements UserDetailsService {

    private SellerService sellerService;

    public void setSellerService(SellerService sellerService) {
        this.sellerService = sellerService;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<GrantedAuthority> grantedAuthority = new ArrayList<GrantedAuthority>();
        grantedAuthority.add(new SimpleGrantedAuthority("ROLE_SELLER"));
        TbSeller tbSeller = sellerService.querySellerByID(username);
        if (tbSeller != null) {
            if ("1".equals(tbSeller.getStatus())) {
                return new User(username, tbSeller.getPassword(), grantedAuthority);
            } else {
                return null;
            }
        } else {
            return null;
        }

    }
}
