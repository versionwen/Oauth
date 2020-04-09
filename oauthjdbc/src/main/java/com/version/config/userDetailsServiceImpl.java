package com.version.config;

import com.version.entity.TbPermission;
import com.version.entity.TbUser;
import com.version.service.TbPermissionService;
import com.version.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author version
 * @version 1.0
 * @date 2020/4/8 19:21
 */
@Service
public class userDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private TbUserService tbUserService;

    @Autowired
    private TbPermissionService tbPermissionService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("-----------"+username);
        // 查询用户信息
        TbUser tbUser = tbUserService.quertByname(username);
        System.out.println("##############");
        System.out.println("**********"+tbUser.getUsername());
        System.out.println("-----------------");
        System.out.println();
        List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
        if (tbUser != null) {
            // 获取用户授权
            List<TbPermission> tbPermissions = tbPermissionService.queryAllPermisson(tbUser.getId());
            // 声明用户授权
            tbPermissions.forEach(tbPermission -> {
                if (tbPermission != null && tbPermission.getEnname() != null) {
                    GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(tbPermission.getEnname());
                    grantedAuthorities.add(grantedAuthority);
                }
            });
        }

        // 由框架完成认证工作
        return new User(tbUser.getUsername(), tbUser.getPassword(), grantedAuthorities);
    }
}
