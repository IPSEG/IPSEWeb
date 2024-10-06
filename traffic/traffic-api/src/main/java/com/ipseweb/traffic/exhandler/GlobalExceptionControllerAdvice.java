package com.ipseweb.traffic.exhandler;


import com.ipseweb.traffic.dto.error.CommonErrorCode;
import com.ipseweb.traffic.dto.error.Response;
import com.ipseweb.traffic.dto.error.Response.ValidationError;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestControllerAdvice
@RequiredArgsConstructor
@Slf4j
public class GlobalExceptionControllerAdvice extends ResponseEntityExceptionHandler {
    private final MessageSource messageSource;

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {

        List<ValidationError> errors = ex.getBindingResult().getFieldErrors()
                .stream()
                .map(c -> ValidationError.of(messageSource, c)).filter(Objects::nonNull).collect(Collectors.toList());

        CommonErrorCode errorCode = CommonErrorCode.INVALID_PARAMETER;
        Response response = new Response(errorCode.getHttpStatus().value(), errorCode.getHttpStatus(), errorCode.getMessage(), errors);

        return handleExceptionInternal(ex, response, headers, status, request);
    }


}
