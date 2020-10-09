package com.lordgasmic.bff.login;

import com.lordgasmic.bff.login.model.LoginRequest;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    private final LoginClient client;

    public LoginService(final LoginClient client){
        this.client = client;
    }

    public Object login(LoginRequest request){
        return client.login(request);
    }
}
