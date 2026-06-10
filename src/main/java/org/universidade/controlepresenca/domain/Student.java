package org.universidade.controlepresenca.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

@Entity @Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
@Table(indexes = @Index(columnList = "classId"))
public class Student {
    @Id @UuidGenerator
    private String id;

    @Column(nullable = false)
    private String name;

    private String registration; // opcional

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ClassId classId;
}
