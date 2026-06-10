// repo/TeacherRepo.java
package org.universidade.controlepresenca.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.universidade.controlepresenca.domain.Teacher;

import java.util.Optional;

public interface TeacherRepo extends JpaRepository<Teacher, String> {
    Optional<Teacher> findByEmail(String email);
}
