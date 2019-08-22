package com.mycasestudy.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BANDWIDTH_LIMIT_EXCEEDED)
public class MaxEntriesExceeded extends RuntimeException {
    public MaxEntriesExceeded() {
    }

    public MaxEntriesExceeded(String message) {
        super(message);
    }

    public MaxEntriesExceeded(String message, Throwable cause) {
        super(message, cause);
    }

    public MaxEntriesExceeded(Throwable cause) {
        super(cause);
    }

    public MaxEntriesExceeded(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
