package com.version;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author version
 * @version 1.0
 * @date 2020/4/5 18:06
 */
public class encode {
    public static void main(String[] args) {
        BCryptPasswordEncoder wx=new BCryptPasswordEncoder();
        String out=wx.encode("secret");
        System.out.println(out);
    }
}
