package org.universidade.controlepresenca.web;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.universidade.controlepresenca.dto.LoginReq;
import org.universidade.controlepresenca.dto.LoginRes;
import org.universidade.controlepresenca.service.AuthService;


@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService svc;

    @PostMapping("/login")
    public LoginRes login(@RequestBody @Valid LoginReq req) {
        return svc.login(req);
    }
}
