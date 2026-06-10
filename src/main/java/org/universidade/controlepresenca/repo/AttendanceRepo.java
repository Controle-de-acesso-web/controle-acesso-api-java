// repo/AttendanceRepo.java
package org.universidade.controlepresenca.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.universidade.controlepresenca.domain.Attendance;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface AttendanceRepo extends JpaRepository<Attendance, String> {
    List<Attendance> findByStudent_ClassIdAndDateOrderByStudent_NameAsc(
            org.universidade.controlepresenca.domain.ClassId classId, LocalDate date);

    Optional<Attendance> findByStudent_IdAndDate(String studentId, LocalDate date);
}
