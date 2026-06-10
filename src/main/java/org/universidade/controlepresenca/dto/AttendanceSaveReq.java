package org.universidade.controlepresenca.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.universidade.controlepresenca.domain.ClassId;

import java.time.LocalDate;
import java.util.List;

public record AttendanceSaveReq(
        @NotNull ClassId classId,
        @NotNull LocalDate date,
        @NotEmpty List<AttendanceItem> items
) { }
