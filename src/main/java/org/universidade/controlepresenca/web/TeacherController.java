package org.universidade.controlepresenca.web;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.universidade.controlepresenca.domain.ClassId;
import org.universidade.controlepresenca.dto.AttendanceRes;
import org.universidade.controlepresenca.dto.AttendanceSaveReq;
import org.universidade.controlepresenca.service.TeacherService;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;


@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/teacher")
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherService svc;

    @GetMapping("/students")
    public List<org.universidade.controlepresenca.domain.Student> students(@RequestParam ClassId classId) {
        return svc.listStudents(classId);
    }


    @GetMapping("/attendance")
    public List<AttendanceRes> attendance(
            @RequestParam ClassId classId,
            @RequestParam LocalDate date
    ) {
        return svc.listAttendance(classId, date);
    }



    @PutMapping("/attendance")
    public ResponseEntity<Map<String, String>> save(@RequestBody @Valid AttendanceSaveReq req) {
        svc.saveAttendance(req);
        return ResponseEntity.ok(Map.of("status", "ok"));  // Retorna 200 OK com JSON
    }

}
