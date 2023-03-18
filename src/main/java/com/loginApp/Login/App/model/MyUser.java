package com.loginApp.Login.App.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

@Getter
@Setter
public class MyUser extends User {

    private String name;
    private String email;
    public MyUser(String username,
                  String password,
                  Collection<GrantedAuthority> authorities,
                  String name,
                  String email
    ) {
        super(username, password, authorities);
        this.name = name;
        this.email = email;
    }

}
