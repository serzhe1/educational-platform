package com.edpl.coursemanagerservice.persistent.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "health")
@Data
public class HealthEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    String health;

}
