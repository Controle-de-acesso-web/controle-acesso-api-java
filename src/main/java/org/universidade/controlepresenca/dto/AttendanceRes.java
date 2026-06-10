package org.universidade.controlepresenca.dto;

import org.universidade.controlepresenca.domain.AttendanceStatus;

public record AttendanceRes(String studentId, AttendanceStatus status) {}
