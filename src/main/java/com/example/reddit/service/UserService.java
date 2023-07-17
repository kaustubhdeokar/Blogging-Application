package com.example.reddit.service;

import com.example.reddit.exception.SpringRedditException;
import com.example.reddit.model.User;
import com.example.reddit.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

import static java.util.Collections.singletonList;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private PasswordEncoder encoder;

    @Autowired private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("user details service.");

        Optional<User> user = userRepo.findByUsername(username);

        if (!user.isPresent()) {
            throw new UsernameNotFoundException("User not present!");
        }
        User verifiedUser = user.get();

        return new org.springframework.security.core.userdetails.
                User(verifiedUser.getUsername(), verifiedUser.getPassword(),
                verifiedUser.isEnabled(), true, true, true,
                getAuthorities("USER"));
    }

    private Collection<? extends GrantedAuthority> getAuthorities(String role) {
        return singletonList(new SimpleGrantedAuthority(role));
    }

    public User getPrincipalUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Optional<User> user = userRepo.findByUsername(authentication.getName());
        if (user.isEmpty()) {
            throw new SpringRedditException("Invalid user.");
        } else if (!user.get().isEnabled()) {
            throw new SpringRedditException("User is not valid.");
        }
        return user.get();
    }

}
