package com.example.jpademo.models;

import jakarta.persistence.*;
import java.util.*;

@Entity
@Table(name = "center")
public class Center {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 100)
    private String name;

    @ElementCollection
    @CollectionTable(name = "center_schedules", joinColumns = @JoinColumn(name = "center_id"))
    @Column(name = "working_day")
    private List<String> workingDays;

    @Column(name = "opening_hours", length = 50)
    private String openingHours; // e.g., "9:00-17:00"

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public List<String> getWorkingDays() { return workingDays; }
    public void setWorkingDays(List<String> workingDays) { this.workingDays = workingDays; }
    public String getOpeningHours() { return openingHours; }
    public void setOpeningHours(String openingHours) { this.openingHours = openingHours; }
}