package org.surfsharing.identityservice.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.surfsharing.identityservice.entity.UserCredential;
import org.surfsharing.identityservice.enums.ERole;

import java.util.Collection;

@Getter
@Setter
public class CustomUserDetails implements UserDetails {
    private int id;
    private String username;
    private String password;
    private ERole role;

    public CustomUserDetails(UserCredential userCredential) {
        this.id = userCredential.getId();
        this.username = userCredential.getName();
        this.password = userCredential.getPassword();
        this.role = userCredential.getRole();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

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
