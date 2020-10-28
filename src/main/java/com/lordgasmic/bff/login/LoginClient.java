package com.lordgasmic.bff.login;

import com.lordgasmic.bff.login.model.LoginRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient(name="login-client", url = "${login-service.url}")
public interface LoginClient {

    @PutMapping(value="/api/v1/login", headers = {""})
    Object login(LoginRequest request);
}