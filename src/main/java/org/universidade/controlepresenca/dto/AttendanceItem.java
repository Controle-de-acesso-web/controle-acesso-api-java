package org.universidade.controlepresenca.dto;

import org.universidade.controlepresenca.domain.AttendanceStatus;

public record AttendanceItem(String studentId, AttendanceStatus status) {}
