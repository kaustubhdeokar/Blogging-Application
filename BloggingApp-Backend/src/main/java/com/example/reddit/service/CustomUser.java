package com.example.reddit.service;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class CustomUser implements UserDetails {

    private final String username;
    private final String password;
    private final Collection<? extends GrantedAuthority> authorities;
    private final boolean isEnabled;
    private final boolean isExpired;
    private final boolean isAccountNonLocked;
    private final boolean isAccountNonExpired;

    public CustomUser(String username, String password, boolean enabled, boolean accountNonExpired,
                      boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities)
    {
        this.username = username;
        this.password = password;
        this.isEnabled = enabled;
        this.isExpired = accountNonExpired;
        this.isAccountNonLocked = accountNonLocked;
        this.isAccountNonExpired = credentialsNonExpired;
        this.authorities = authorities;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return isAccountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return isAccountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return isExpired;
    }

    @Override
    public boolean isEnabled() {
        return isEnabled;
    }
}
