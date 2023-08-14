package com.lordgasmic.bff.session;

import com.lordgasmic.bff.configuration.LordgasmicConstants;
import com.lordgasmic.bff.session.model.SessionDetails;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Slf4j
@Component
public class SessionManager {

    @Autowired
    private HttpServletRequest httpServletRequest;

    private static final Map<String, Object> SESSION_MAP = new HashMap<>();

    public SessionDetails getSessionDetails(String token) {
        return (SessionDetails) SESSION_MAP.get(token);
    }

    public String handleLogin(final SessionDetails sessionDetails) {
//        httpServletRequest.getSession().invalidate();
//        httpServletRequest.getSession(true);
//        httpServletRequest.getSession().setAttribute(LordgasmicConstants.SESSION_DETAILS_ATTRIBUTE_NAME, sessionDetails);

        String token = UUID.randomUUID().toString();
        SESSION_MAP.put(token, sessionDetails);

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
