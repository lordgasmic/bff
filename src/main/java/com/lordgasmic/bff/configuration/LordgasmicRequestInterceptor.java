package com.lordgasmic.bff.configuration;

//@Component
//@Slf4j
//public class LordgasmicRequestInterceptor implements HandlerInterceptor {
//
//    private final SessionManager sessionManager;
//
//    public LordgasmicRequestInterceptor(SessionManager sessionManager) {
//        this.sessionManager = sessionManager;
//    }
//
//    @Override
//    public boolean preHandle(HttpServletRequest request, final HttpServletResponse response, final Object handler) {
//        log.info("starting preHandle");
//        if (request.getServletPath().contains("api/v1/login")) {
//            log.info("login handler found");
//            return true;
//        }
//
//        if (request.getMethod().equalsIgnoreCase("OPTIONS")) {
//            log.info("OPTIONS preflight found");
//            return true;
//        }
//
//        if (request.getServletPath().contains("api/v1/slack-commands")) {
//            // check authentication at the bff controller
//            return true;
//        }
//
//        String token = request.getHeader(LordgasmicConstants.LORDGASMIC_AUTH_TOKEN);
//        if (token == null) {
//            response.setStatus(401);
//            return false;
//        }
//
//        final SessionDetails details = sessionManager.getSessionDetails(token);
//        if (details == null) {
//            response.setStatus(401);
//            return false;
//        }
//        log.info("session details {}", details);
//        // todo validate user has access to requested role in addition to user
//        return details.getUsername() != null && Role.hasRole(Role.user, details.getRoles());
//    }
//}
