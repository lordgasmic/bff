package com.lordgasmic.bff.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
public class LordgasmicCorsConfiguration {

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        final CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.applyPermitDefaultValues();
        corsConfiguration.addAllowedMethod("PUT");
        corsConfiguration.addAllowedMethod("DELETE");

        final UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
        urlBasedCorsConfigurationSource
                .registerCorsConfiguration("/**", corsConfiguration);
        return urlBasedCorsConfigurationSource;
    }
}
