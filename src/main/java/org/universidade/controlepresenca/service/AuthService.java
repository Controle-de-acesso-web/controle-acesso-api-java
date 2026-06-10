package org.universidade.controlepresenca.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.universidade.controlepresenca.dto.LoginReq;
import org.universidade.controlepresenca.dto.LoginRes;
import org.universidade.controlepresenca.repo.TeacherRepo;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final TeacherRepo teacherRepo;
    private final PasswordEncoder encoder;

    public LoginRes login(LoginReq req) {
        var t = teacherRepo.findByEmail(req.email().toLowerCase())
                .orElseThrow(InvalidCredentialsException::new);

        if (!encoder.matches(req.password(), t.getPasswordHash())) {
            throw new InvalidCredentialsException();
        }

        return new LoginRes(t.getId(), t.getName(), "teacher", t.getClassId());
    }
}
