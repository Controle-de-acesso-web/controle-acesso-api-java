package org.universidade.controlepresenca.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.universidade.controlepresenca.domain.Attendance;
import org.universidade.controlepresenca.domain.ClassId;
import org.universidade.controlepresenca.dto.AttendanceItem;
import org.universidade.controlepresenca.dto.AttendanceSaveReq;
import org.universidade.controlepresenca.dto.AttendanceRes;   // <<< IMPORTANTE
import org.universidade.controlepresenca.repo.AttendanceRepo;
import org.universidade.controlepresenca.repo.StudentRepo;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {
    private final StudentRepo studentRepo;
    private final AttendanceRepo attendanceRepo;

    public List<org.universidade.controlepresenca.domain.Student> listStudents(ClassId classId) {
        return studentRepo.findByClassIdOrderByNameAsc(classId);
    }

    // <<< ALTERAR ESTE MÉTODO
    public List<AttendanceRes> listAttendance(ClassId classId, LocalDate date) {
        return attendanceRepo
                .findByStudent_ClassIdAndDateOrderByStudent_NameAsc(classId, date)
                .stream()
                .map(a -> new AttendanceRes(
                        a.getStudent().getId(), // id do aluno
                        a.getStatus()           // pode ser null
                ))
                .toList();
    }

    public void saveAttendance(AttendanceSaveReq req) {
        var date = req.date();
        for (AttendanceItem it : req.items()) {
            var att = attendanceRepo.findByStudent_IdAndDate(it.studentId(), date)
                    .orElseGet(() -> Attendance.builder()
                            .student(studentRepo.findById(it.studentId()).orElseThrow())
                            .date(date)
                            .build());
            att.setStatus(it.status()); // pode ser null
            attendanceRepo.save(att);
        }
    }
}
