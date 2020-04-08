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

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

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
        TbUser tbUser=tbUserService.quertByname(username);
        List<GrantedAuthority>grantedAuthorities=new List<GrantedAuthority>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator<GrantedAuthority> iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] a) {
                return null;
            }

            @Override
            public boolean add(GrantedAuthority grantedAuthority) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends GrantedAuthority> c) {
                return false;
            }

            @Override
            public boolean addAll(int index, Collection<? extends GrantedAuthority> c) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> c) {
                return false;
            }

            @Override
            public void clear() {

            }

            @Override
            public GrantedAuthority get(int index) {
                return null;
            }

            @Override
            public GrantedAuthority set(int index, GrantedAuthority element) {
                return null;
            }

            @Override
            public void add(int index, GrantedAuthority element) {

            }

            @Override
            public GrantedAuthority remove(int index) {
                return null;
            }

            @Override
            public int indexOf(Object o) {
                return 0;
            }

            @Override
            public int lastIndexOf(Object o) {
                return 0;
            }

            @Override
            public ListIterator<GrantedAuthority> listIterator() {
                return null;
            }

            @Override
            public ListIterator<GrantedAuthority> listIterator(int index) {
                return null;
            }

            @Override
            public List<GrantedAuthority> subList(int fromIndex, int toIndex) {
                return null;
            }
        };
        if(tbUser!=null){
            List<TbPermission>tbPermissions=tbPermissionService.queryAllPermisson(tbUser.getId());
            tbPermissions.forEach(tbPermission -> {GrantedAuthority grantedAuthority=new SimpleGrantedAuthority(tbPermission.getEnname());
            grantedAuthorities.add(grantedAuthority);
            });
        }
        return new User(tbUser.getUsername(),tbUser.getPassword(),grantedAuthorities);
    }
}
