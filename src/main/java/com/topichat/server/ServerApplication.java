package com.topichat.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.AbstractRequestLoggingFilter;

import javax.servlet.Filter;
import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.function.Consumer;
import java.util.stream.Stream;

@SpringBootApplication
public class ServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerApplication.class, args);
    }

    @Bean
    public Filter logFilter() {
        return new AbstractRequestLoggingFilter() {
            private final Logger logger = LoggerFactory.getLogger(Filter.class);

            @Override
            protected void beforeRequest(HttpServletRequest request, String message) {
                logger.info("Request {} {} {}", request.getMethod(), request.getRequestURI(), request.getQueryString());

                Enumeration headers = request.getHeaderNames();
                while (headers.hasMoreElements()) {
                    String header = (String) headers.nextElement();
                    logger.info("Header {} : {}", header, request.getHeader(header));
                }
            }

            @Override
            protected void afterRequest(HttpServletRequest request, String message) {

            }
        };
    }
}
