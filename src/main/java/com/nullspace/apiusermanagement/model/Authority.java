package com.nullspace.apiusermanagement.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Table(name = "authority")
public class Authority extends BaseEntity implements GrantedAuthority {

    @Enumerated(EnumType.STRING)
    @Column(name = "name")
    private UserRoleName name;

    public Authority(Long id, UserRoleName name) {
        super(id);
        this.name = name;
    }

    @Override
    public String getAuthority() {
        return name.name();
    }

    public void setName(UserRoleName name) {
        this.name = name;
    }

    @JsonIgnore
    public UserRoleName getName() {
        return name;
    }

    @JsonIgnore
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
