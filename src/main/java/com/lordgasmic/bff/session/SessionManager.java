package com.lordgasmic.bff.session;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Component
public class SessionManager {

    @Autowired
    private HttpServletRequest httpServletRequest;

    public void getSessionDetails(){
        httpServletRequest.getSession().getAttributeNames().asIterator().forEachRemaining(System.out::println);
    }
}
