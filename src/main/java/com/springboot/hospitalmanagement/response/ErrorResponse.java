package com.springboot.hospitalmanagement.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@AllArgsConstructor
public class ErrorResponse {

    private Object message;
    private LocalDateTime timestamp;

    public ErrorResponse(List<String> message, LocalDateTime timestamp) {
        this.message = message;
        this.timestamp = timestamp;
    }
}
