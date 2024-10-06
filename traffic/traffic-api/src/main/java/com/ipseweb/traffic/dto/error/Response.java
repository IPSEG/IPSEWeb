package com.ipseweb.traffic.dto.error;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Objects;


@Getter
@Builder
@RequiredArgsConstructor
@Slf4j
public class Response<T> {

    private final Integer code;

    private final HttpStatus status;

    private final String message;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private final List<ValidationError> errors;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private T data;


    public static <T> Response<T> success(T data) {
        return new Response<>(SuccessCode.SUCCESS.getHttpStatus().value(),
                SuccessCode.SUCCESS.getHttpStatus(),
                SuccessCode.SUCCESS.getMessage(),
                null,
                data);
    }

    public Response(Integer code, HttpStatus status, String message, List<ValidationError> errors, T data) {
        this.code = code;
        this.status = status;
        this.message = message;
        this.errors = errors;
        this.data = data;
    }



    @Getter
    @Builder
    @RequiredArgsConstructor
    @Slf4j
    public static class ValidationError{
        private final String field;
        private final String message;

        public static ValidationError of(final MessageSource messageSource, final FieldError fieldError) {


            String message = Arrays.stream(Objects.requireNonNull(fieldError.getCodes()))
                    .map(c -> {
                        Object[] arguments = fieldError.getArguments();
                        Locale locale = LocaleContextHolder.getLocale();
                        try {
                            return messageSource.getMessage(c, arguments, locale);
                        } catch (NoSuchMessageException e) {
                            log.error("[ValidationError]", e);
                            return null;
                        }
                    }).filter(Objects::nonNull)
                    .findFirst()
                    .orElse(fieldError.getDefaultMessage());


            return ValidationError.builder()
                    .field(fieldError.getField())
                    .message(message)
                    .build();
        }


    }







}
