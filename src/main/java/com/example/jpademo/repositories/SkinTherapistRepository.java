package com.example.jpademo.repositories;

import com.example.jpademo.models.SkinTherapist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkinTherapistRepository extends JpaRepository<SkinTherapist, Long> {
}