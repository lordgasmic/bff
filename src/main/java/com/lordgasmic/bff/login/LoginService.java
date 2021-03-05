package com.lordgasmic.bff.login;

import com.lordgasmic.bff.login.model.LoginRequest;
import com.lordgasmic.bff.login.model.LoginResponse;
import com.lordgasmic.bff.session.SessionManager;
import com.lordgasmic.bff.session.model.SessionDetails;
import com.lordgasmic.bff.session.model.SessionDetailsMapper;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    private final LoginClient client;
    private final SessionManager sessionManager;

    public LoginService(final LoginClient client, SessionManager sessionManager){
        this.client = client;
        this.sessionManager = sessionManager;
    }

    public Object login(LoginRequest request){
        LoginResponse response = client.login(request);

        if (response.isCredentialsValid() && response.isEnabled()) {
            SessionDetails sessionDetails = SessionDetailsMapper.fromLoginResponse(response);
            sessionManager.handleLogin(sessionDetails);
            return sessionDetails;
        }

        return null;
    }

    public void logout() {
        sessionManager.handleLogout();
    }
}
