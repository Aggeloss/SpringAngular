package com.apiproject.tect.security;

import com.apiproject.tect.entities.AppUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class CustomeUserPrincipal extends User {

    private AppUser user;

    public CustomeUserPrincipal(AppUser user, String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
        this.user = user;
    }

    public long getId() {
        return this.user.getId();
    }
}
