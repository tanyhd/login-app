package com.loginApp.Login.App.service;

import com.loginApp.Login.App.model.MyUser;
import com.loginApp.Login.App.model.Role;
import com.loginApp.Login.App.model.User;
import com.loginApp.Login.App.respository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(usernameOrEmail);
        if (user != null) {
            return new MyUser(user.getUsername(),
                    user.getPassword(),
                    List.of(new SimpleGrantedAuthority(user.getRole().name())),
                    user.getName(),
                    user.getEmail());
        } else {
            throw new UsernameNotFoundException("Invalid email or password");
        }
    }

}
