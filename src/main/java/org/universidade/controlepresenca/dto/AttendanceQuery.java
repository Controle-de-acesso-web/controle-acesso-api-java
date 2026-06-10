package org.universidade.controlepresenca.dto;

import java.time.LocalDate;

public record AttendanceQuery(String classId, LocalDate date) {}
