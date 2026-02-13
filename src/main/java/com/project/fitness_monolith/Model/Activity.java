package com.project.fitness_monolith.Model;


import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.util.Map;

@Entity
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)


    private String id;
    @Enumerated(EnumType.STRING)


    private ActivityType type;

    // by default in database level it store values like 1,2,3, but we want to store naming like cycle, walking so that's why used enum
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "json")
    private Map<String , Object> additionalMetrics;

    private Integer duration;
    private Integer caloriesBurned;
    private LocalDateTime startTime;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;



}
