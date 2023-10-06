package com.afzdev.gameapi.dto.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
public class ErrorResponse {

    private Instant timeStamp;
    private Integer httpStatus;
    private String message;
    private String exception;
    private String path;

}
