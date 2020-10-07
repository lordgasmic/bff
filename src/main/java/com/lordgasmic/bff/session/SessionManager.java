package com.lordgasmic.bff.session;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.logging.Logger;

@Slf4j
@Component
public class SessionManager {

    @Autowired
    private HttpServletRequest httpServletRequest;

    public void getSessionDetails(){
        log.debug("getSessionDetails begin");
        Enumeration<String> attrs = httpServletRequest.getSession().getAttributeNames();
        while(attrs.hasMoreElements()) {
            log.info(attrs.nextElement());
        }
        log.debug("getSessionDetails end");
    }
}
