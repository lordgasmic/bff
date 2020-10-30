package com.lordgasmic.bff.session;

import com.lordgasmic.bff.session.model.SessionDetails;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class SessionController {

    @Autowired
    private SessionManager sessionManager;

    @GetMapping("/api/v1/session/{id}")
    public SessionDetails getSessionInfo(@PathVariable int id) {
        return sessionManager.getSessionDetails(id);
    }
}
