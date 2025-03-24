package com.example.jpademo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.jpademo.models.Permission;

import java.util.*;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, Long>  {
   List<Permission> findAll();

}
