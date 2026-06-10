package org.universidade.controlepresenca.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.universidade.controlepresenca.domain.ClassId;

public record AdminCreateTeacherReq(
        @NotBlank String name,
        @NotBlank @Email String email,
        @NotBlank String password,
        @NotNull ClassId classId
) {}
