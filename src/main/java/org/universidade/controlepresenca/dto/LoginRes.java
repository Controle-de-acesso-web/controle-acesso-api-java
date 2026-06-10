package org.universidade.controlepresenca.dto;

import org.universidade.controlepresenca.domain.ClassId;

public record LoginRes(String id, String name, String role, ClassId classId) {}
