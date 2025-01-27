package com.example.reddit.service;

import com.example.reddit.exception.CustomException;
import com.example.reddit.model.User;
import com.example.reddit.repo.UserRepo;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.Collections.singletonList;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepo userRepo;

    public CustomUserDetailsService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("user details service.");
        Optional<User> user = userRepo.findByUsername(username);
        if (user.isEmpty()) {
            throw new UsernameNotFoundException("User not present!");
        }
        User verifiedUser = user.get();
        Set<GrantedAuthority> authorities = verifiedUser.getRoles().stream()
                .map((role) -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toSet());

        return new CustomUser(verifiedUser.getUsername(), verifiedUser.getPassword(),
                verifiedUser.isEnabled(), true, true, true,
                authorities);
    }

    private Collection<? extends GrantedAuthority> getAuthorities(String role) {
        return singletonList(new SimpleGrantedAuthority(role));
    }

    public User getPrincipalUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Optional<User> user = userRepo.findByUsername(authentication.getName());
        if (user.isEmpty()) {
            throw new CustomException("Invalid user.");
        } else if (!user.get().isEnabled()) {
            throw new CustomException("User is not valid.");
        }
        return user.get();
    }

}
