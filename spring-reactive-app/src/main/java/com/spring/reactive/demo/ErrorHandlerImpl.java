package com.spring.reactive.demo;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.server.WebExceptionHandler;
import org.springframework.web.server.WebHandler;
import org.springframework.web.server.handler.ExceptionHandlingWebHandler;

import java.util.List;

@ControllerAdvice
public class ErrorHandlerImpl extends ExceptionHandlingWebHandler {
    public ErrorHandlerImpl(WebHandler delegate, List<WebExceptionHandler> handlers) {
        super(delegate, handlers);
    }

}
