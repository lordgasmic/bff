package com.lordgasmic.bff.configuration;

import com.lordgasmic.bff.login.model.Role;
import com.lordgasmic.bff.session.SessionManager;
import com.lordgasmic.bff.session.model.SessionDetails;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
public class LordgasmicRequestInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private SessionManager sessionManager;

    @Override
    public boolean preHandle(final HttpServletRequest request, final HttpServletResponse response, final Object handler) throws IOException {
        log.info("starting preHandle");
        if (request.getServletPath().contains("api/v1/login")) {
            log.info("login handler found");
            return true;
        }

        if (request.getMethod().equalsIgnoreCase("OPTIONS")) {
            log.info("OPTIONS preflight found");
            return true;
        }

        if (request.getServletPath().contains("api/v1/slack-commands")) {
            //            ContentCachingRequestWrapper cachedRequest = new ContentCachingRequestWrapper(request);
            //            List<String> body = cachedRequest.getReader().lines().collect(Collectors.toList());
            //            for (String string : body) {
            //                String[] parsedBody = string.split("&");
            //                for (String s : parsedBody) {
            //                    if (s.contains("token=")) {
            //                        if (s.contains("IQM722ANTHK6DwpbnKZcy7op")) {
            //                            log.info("Authenticated request for slack commands");
            //                            return true;
            //                        }
            //                    }
            //                }
            //            }
            //            return false;
            return true;
        }

        String token = request.getHeader(LordgasmicConstants.LORDGASMIC_AUTH_TOKEN);
        if (token == null) {
            response.setStatus(401);
            return false;
        }

        final SessionDetails details = sessionManager.getSessionDetails(token);
        if (details == null) {
            response.setStatus(401);
            return false;
        }
        log.info("session details {}", details);
        return details.getUsername() != null && Role.hasRole(Role.user, details.getRoles());
    }
}
