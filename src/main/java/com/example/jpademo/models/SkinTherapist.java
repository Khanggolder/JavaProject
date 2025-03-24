package com.example.jpademo.models;

import jakarta.persistence.*;
import java.util.*;

@Entity
@Table(name = "skin_therapists")
public class SkinTherapist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user; // Link to User entity with role "THERAPIST"

    @Column(name = "full_name", length = 100)
    private String fullName;

    @Column(name = "specialty", length = 100)
    private String specialty;

    @Column(name = "experience_years")
    private int experienceYears;

    @ElementCollection
    @CollectionTable(name = "therapist_schedules", joinColumns = @JoinColumn(name = "therapist_id"))
    @Column(name = "working_day")
    private List<String> workingDays; // e.g., ["Monday", "Wednesday"]

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }
    public String getSpecialty() { return specialty; }
    public void setSpecialty(String specialty) { this.specialty = specialty; }
    public int getExperienceYears() { return experienceYears; }
    public void setExperienceYears(int experienceYears) { this.experienceYears = experienceYears; }
    public List<String> getWorkingDays() { return workingDays; }
    public void setWorkingDays(List<String> workingDays) { this.workingDays = workingDays; }
}