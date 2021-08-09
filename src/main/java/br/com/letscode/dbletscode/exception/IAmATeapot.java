package br.com.letscode.dbletscode.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
public class IAmATeapot extends RuntimeException {
    public IAmATeapot() {
        super("I CAN'T");
    }
}
