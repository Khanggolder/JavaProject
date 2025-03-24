package com.example.jpademo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.jpademo.services.PermissionService;
import com.example.jpademo.models.Permission;
import java.util.List;

@RestController
@RequestMapping("/per")
public class PermissionController {
    @Autowired
    private PermissionService permissionService;

    // Lấy danh sách tất cả permissions
    @GetMapping("/permissions")
    public List<Permission> getAllPermissions() {
        return permissionService.findAll();
    }

    // Thêm mới permission
    @PostMapping("/permission")
    public Permission addPermission(@RequestBody Permission permission) {
        return permissionService.createPermission(permission); // Sửa tên phương thức
    }

    // Cập nhật permission theo id
    @PutMapping("/permission/{id}")
    public Permission updatePermission(@PathVariable Long id, @RequestBody Permission permission) {
        permission.setId(id); // Đặt id từ URL vào object
        return permissionService.updatePermission(permission); // Gọi phương thức update
    }
}