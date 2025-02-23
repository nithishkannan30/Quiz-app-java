package com.Quiz.Authentication.Security;

import com.Quiz.Authentication.UserDetails.UserInfo;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserInfoDetails implements UserDetails {

    private final String userName;
    private final String password;
    private final List<GrantedAuthority> authorities;

    public UserInfoDetails(UserInfo userInfo) {
        this.userName = userInfo.getEmail();  // Use email as username
        System.out.println("Loaded user: " + userName);
        this.password = userInfo.getPassword();
        this.authorities = new ArrayList<>();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    // For simplicity, other methods return true
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    @Override
    public boolean isEnabled() {
        return true;
    }
}
