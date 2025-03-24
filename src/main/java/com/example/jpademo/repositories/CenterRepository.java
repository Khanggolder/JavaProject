package com.example.jpademo.repositories;

import com.example.jpademo.models.Center;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CenterRepository extends JpaRepository<Center, Long> {
}