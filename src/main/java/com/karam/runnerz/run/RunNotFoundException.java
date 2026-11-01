package com.karam.runnerz.run;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class RunNotFoundException extends RuntimeException {
    public RunNotFoundException(String message) {
        super(message);
    }
}
