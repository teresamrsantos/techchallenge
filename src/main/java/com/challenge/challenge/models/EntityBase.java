package com.challenge.challenge.models;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Data
@MappedSuperclass
public class EntityBase implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, updatable = false, unique = true)
    private UUID uuid;

    @PrePersist
    private void setUuid() {
        this.setUuid(UUID.randomUUID());
    }
}