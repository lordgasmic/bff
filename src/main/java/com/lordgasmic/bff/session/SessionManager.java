package com.lordgasmic.bff.session;

import com.lordgasmic.bff.session.model.SessionDetails;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

@Slf4j
@Component
public class SessionManager {

    @Autowired
    private HttpServletRequest httpServletRequest;

    public void getSessionDetails(int id){
        Enumeration<String> attrs = httpServletRequest.getSession().getAttributeNames();
        while(attrs.hasMoreElements()) {
            String key = attrs.nextElement();
            log.info(key);
            if (key.equals("derp")){
            }
        }
        if (!attrs.hasMoreElements()) {
            save(id);
        }
    }

    public void handleLogin(SessionDetails sessionDetails) {
        httpServletRequest.getSession(false).invalidate();
        httpServletRequest.getSession(true);
        httpServletRequest.getSession().setAttribute("", sessionDetails);
        httpServletRequest.changeSessionId();
    }

    public void save(int id) {
        httpServletRequest.getSession().setAttribute("derp", "derp-true:" + id);
    }
}
