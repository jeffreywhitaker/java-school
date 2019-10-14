package com.lambdaschool.school.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException
{
    public ResourceNotFoundException(String message)
    {
        super(message + "not found. Please Try Again ");
    }

    public ResourceNotFoundException(String message, Throwable cause)
    {
        super(message + "not found. Please Tr Again ", cause);
    }
}
