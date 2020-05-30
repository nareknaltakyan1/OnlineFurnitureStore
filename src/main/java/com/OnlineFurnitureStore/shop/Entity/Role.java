package com.OnlineFurnitureStore.shop.Entity;

import com.OnlineFurnitureStore.shop.Enum.UserRole;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class Role implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    private UserRole role;

    public Role() {
    }


    public Role(UserRole role) {
        this.role = role;
    }

    @Override
    public String getAuthority() {
        return role.name();
    }
}