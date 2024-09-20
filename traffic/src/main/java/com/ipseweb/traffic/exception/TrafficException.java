package com.ipseweb.traffic.exception;

import com.ipseweb.traffic.dto.ErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class TrafficException extends RuntimeException{
    private final ErrorCode errorCode;
}
