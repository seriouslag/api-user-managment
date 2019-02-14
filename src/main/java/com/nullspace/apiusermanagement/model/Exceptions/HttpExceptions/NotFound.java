package com.nullspace.apiusermanagement.model.Exceptions.HttpExceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NotFound extends RuntimeException {

}
