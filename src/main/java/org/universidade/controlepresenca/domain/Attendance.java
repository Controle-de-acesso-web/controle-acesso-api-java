package org.universidade.controlepresenca.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDate;

@Entity @Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
@Table(
        uniqueConstraints = @UniqueConstraint(columnNames = {"student_id", "date"})
)
public class Attendance {
    @Id @UuidGenerator
    private String id;

    @ManyToOne(optional = false)
    private Student student;

    @Column(nullable = false)
    private LocalDate date;

    @Enumerated(EnumType.STRING)
    private AttendanceStatus status; // pode ser null (em branco)
}
