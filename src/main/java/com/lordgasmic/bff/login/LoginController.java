package com.lordgasmic.bff.login;

import com.lordgasmic.bff.login.model.LoginRequest;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
public class LoginController {

    private final LoginService service;

    public LoginController(final LoginService service){
        this.service = service;
    }

    @PostMapping("/api/v1/login")
    public Object login(@RequestBody LoginRequest request){
        return service.login(request);
    }

    @GetMapping("/api/v1/logout")
    public void logout() {
        service.logout();
    }
}