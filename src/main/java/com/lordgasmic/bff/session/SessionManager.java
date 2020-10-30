package com.lordgasmic.bff.session;

import com.lordgasmic.bff.configuration.LordgasmicConstants;
import com.lordgasmic.bff.session.model.SessionDetails;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Component
public class SessionManager {

    @Autowired
    private HttpServletRequest httpServletRequest;

    public SessionDetails getSessionDetails(int id){
        return (SessionDetails) httpServletRequest.getSession().getAttribute(LordgasmicConstants.SESSION_DETAILS_ATTRIBUTE_NAME);
    }

    public void handleLogin(SessionDetails sessionDetails) {
        httpServletRequest.getSession(false).invalidate();
        httpServletRequest.getSession(true);
        httpServletRequest.getSession().setAttribute(LordgasmicConstants.SESSION_DETAILS_ATTRIBUTE_NAME, sessionDetails);
    }

    public void save(int id) {
        httpServletRequest.getSession().setAttribute("derp", "derp-true:" + id);
    }
}
