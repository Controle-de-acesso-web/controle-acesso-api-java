package org.universidade.controlepresenca.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.universidade.controlepresenca.domain.Student;
import org.universidade.controlepresenca.domain.Teacher;
import org.universidade.controlepresenca.dto.AdminCreateStudentReq;
import org.universidade.controlepresenca.dto.AdminCreateTeacherReq;
import org.universidade.controlepresenca.repo.StudentRepo;
import org.universidade.controlepresenca.repo.TeacherRepo;

@Service @RequiredArgsConstructor
public class AdminService {
    private final TeacherRepo teacherRepo;
    private final StudentRepo studentRepo;
    private final PasswordEncoder encoder;

    public Teacher createTeacher(AdminCreateTeacherReq req) {
        Teacher teacher = Teacher.builder()
                .name(req.name())
                .email(req.email().toLowerCase())
                .passwordHash(encoder.encode(req.password()))
                .classId(req.classId())
                .build();
        return teacherRepo.save(teacher);
    }

    public Student createStudent(AdminCreateStudentReq req) {
        Student student = Student.builder()
                .name(req.name())
                .registration(req.registration())
                .classId(req.classId())
                .build();
        return studentRepo.save(student);
    }
}
