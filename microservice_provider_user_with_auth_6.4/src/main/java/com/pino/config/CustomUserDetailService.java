package com.pino.config;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * Created by yin on 2019/1/15.
 * Description:
 */
@Component
public class CustomUserDetailService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        if("user".equals(s)){
            return new SecurityUser("user","pwd1","user-role");
        }else if("admin".equals(s)){
            return new SecurityUser("admin","pwd2","admin-role");
        }else{
            return null;
        }
    }
}
