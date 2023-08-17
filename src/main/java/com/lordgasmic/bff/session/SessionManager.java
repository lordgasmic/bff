package com.lordgasmic.bff.session;

import com.lordgasmic.bff.configuration.StudentRepository;
import com.lordgasmic.bff.configuration.models.Student;
import com.lordgasmic.bff.session.model.SessionDetails;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Slf4j
@Component
public class SessionManager {

    private final HttpServletRequest httpServletRequest;
    private final StudentRepository studentRepository;

    public SessionManager(HttpServletRequest httpServletRequest, StudentRepository studentRepository) {
        this.httpServletRequest = httpServletRequest;
        this.studentRepository = studentRepository;
    }

    private static final Map<String, SessionDetails> SESSION_MAP = new HashMap<>();

    public SessionDetails getSessionDetails(String token) {
        log.info("token: " + token);
        log.info("session details: " + SESSION_MAP.get(token));
        return SESSION_MAP.get(token);
    }

    public String handleLogin(final SessionDetails sessionDetails) {
        //        httpServletRequest.getSession().invalidate();
        //        httpServletRequest.getSession(true);
        //        httpServletRequest.getSession().setAttribute(LordgasmicConstants.SESSION_DETAILS_ATTRIBUTE_NAME, sessionDetails);

        String token = UUID.randomUUID().toString();
        SESSION_MAP.put(token, sessionDetails);

        Student s = new Student();
        s.setId(token);
        s.setName(sessionDetails.getUsername());

        return token;
    }

    public void handleLogout(String token) {
        //        httpServletRequest.getSession().removeAttribute(LordgasmicConstants.SESSION_DETAILS_ATTRIBUTE_NAME);
        //        httpServletRequest.getSession().invalidate();
        //        httpServletRequest.getSession(true);

        SESSION_MAP.remove(token);
    }

    public void save(final int id) {
        httpServletRequest.getSession().setAttribute("derp", "derp-true:" + id);
    }
}
