package com.lordgasmic.bff.configuration;

import org.springframework.stereotype.Component;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Component
public class CorsFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", List.of(LordgasmicConstants.LORDGASMIC_AUTH_TOKEN, "Content-Type").toString());
        //        response.setHeader("Access-Control-Allow-Headers",
        //                           "Content-Type, Authorization, Content-Length, X-Requested-With, " + LordgasmicConstants.LORDGASMIC_AUTH_TOKEN + ", " + LordgasmicConstants.LORDGASMIC_AUTH_TOKEN.toLowerCase());
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
