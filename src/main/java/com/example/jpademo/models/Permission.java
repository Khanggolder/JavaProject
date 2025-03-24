package com.example.jpademo.models;

import jakarta.persistence.*;
import java.util.*;
@Entity
public class Permission {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Code", length = 50)
    private String code;

    @Column(name = "permission_name", length = 100)
    private String permissionName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }
@ManyToMany(mappedBy="permissions")
    private Set<User> users = new HashSet<>();
    public Set<User> getUsers() {return users;}
    public void setUsers(Set<User> users) {this.users = users;}
}