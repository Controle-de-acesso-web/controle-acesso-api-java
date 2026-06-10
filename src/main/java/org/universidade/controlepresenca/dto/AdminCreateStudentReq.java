package org.universidade.controlepresenca.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.universidade.controlepresenca.domain.ClassId;

public record AdminCreateStudentReq(
        @NotBlank String name,
        String registration,
        @NotNull ClassId classId
) {}
