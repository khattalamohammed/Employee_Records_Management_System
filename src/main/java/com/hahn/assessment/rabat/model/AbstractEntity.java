package com.hahn.assessment.rabat.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.io.Serializable;
import java.time.LocalDate;

@MappedSuperclass

@Getter @Setter
@EntityListeners(AbstractEntity.EntityListener.class)
@Where(clause = "deleted_at IS NULL")
@SQLDelete(sql = "UPDATE #{entityName} SET deleted_at = CURRENT_DATE WHERE id = ?")
public class AbstractEntity implements Serializable {
    private static final long serialVersionUID = -9067008980429974535L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created_at", nullable = false)
    private LocalDate createdAt;

    @Column(name = "updated_at", nullable = false)
    private LocalDate updatedAt;

    @Column(name = "deleted_at")
    private LocalDate deletedAt;

    // Entity Listener class to handle automatic date management
    public static class EntityListener {
        @PrePersist
        public void prePersist(AbstractEntity entity) {
            LocalDate now = LocalDate.now();
            entity.createdAt = now;
            entity.updatedAt = now;
        }

        @PreUpdate
        public void preUpdate(AbstractEntity entity) {
            entity.updatedAt = LocalDate.now();
        }
    }
}
