package org.universidade.controlepresenca.web;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.universidade.controlepresenca.domain.Student;
import org.universidade.controlepresenca.domain.Teacher;
import org.universidade.controlepresenca.dto.AdminCreateStudentReq;
import org.universidade.controlepresenca.dto.AdminCreateTeacherReq;
import org.universidade.controlepresenca.service.AdminService;



@CrossOrigin(origins = "http://localhost:8081")
@RequiredArgsConstructor
@RestController
@RequestMapping("/admin")
public class AdminController {
    private final AdminService svc;

    @PostMapping("/teachers")
    @ResponseStatus(HttpStatus.CREATED)
    public Teacher createTeacher(@RequestBody @Valid AdminCreateTeacherReq req) {
        return svc.createTeacher(req);
    }

    @PostMapping("/students")
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStudent(@RequestBody @Valid AdminCreateStudentReq req) {
        return svc.createStudent(req);
    }
}
