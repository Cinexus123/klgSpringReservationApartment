package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT, reason = "Reservation not available for this period of time")
public class ReservationNotAvailableException extends RuntimeException{

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
