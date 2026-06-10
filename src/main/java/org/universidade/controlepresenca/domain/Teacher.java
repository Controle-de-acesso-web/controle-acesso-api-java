package org.universidade.controlepresenca.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

@Entity @Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Teacher {
    @Id @UuidGenerator
    private String id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String passwordHash;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ClassId classId;
}
