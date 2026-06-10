// repo/StudentRepo.java
package org.universidade.controlepresenca.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.universidade.controlepresenca.domain.ClassId;
import org.universidade.controlepresenca.domain.Student;

import java.util.List;

public interface StudentRepo extends JpaRepository<Student, String> {
    List<Student> findByClassIdOrderByNameAsc(ClassId classId);
}

