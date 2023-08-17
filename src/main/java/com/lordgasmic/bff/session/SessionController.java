package com.lordgasmic.bff.session;

import com.lordgasmic.bff.configuration.LordgasmicConstants;
import com.lordgasmic.bff.session.model.SessionDetails;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class SessionController {

    private final SessionManager sessionManager;

    public SessionController(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }

    @GetMapping("/api/v1/session")
    public SessionDetails getSessionInfo(@RequestHeader(LordgasmicConstants.LORDGASMIC_AUTH_TOKEN) String token) {
        return sessionManager.getSessionDetails(token);
    }
}
