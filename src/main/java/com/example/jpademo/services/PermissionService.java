package com.example.jpademo.services;

import com.example.jpademo.models.Permission;
import com.example.jpademo.repositories.PermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionService {
    @Autowired
    private PermissionRepository permissionRepository;

    public List<Permission> findAll() {
        return permissionRepository.findAll();
    }

    public Permission createPermission(Permission permission) {
        return permissionRepository.save(permission);
    }

    public Permission updatePermission(Permission permission) {
        return permissionRepository.save(permission);
    }
}