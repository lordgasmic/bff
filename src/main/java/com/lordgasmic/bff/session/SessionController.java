package com.lordgasmic.bff.session;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class SessionController {

    @Autowired
    private SessionManager sessionManager;

    @GetMapping("/api/v1/session")
//    public void getSessionInfo(@RequestParam int id) {
    public void getSessionInfo() {
        sessionManager.getSessionDetails(1);
    }

//    @GetMapping("/api/v1/sessionlogin")
//    public void login(@PathVariable int id) {
//        sessionManager.login(id);
//    }
}
