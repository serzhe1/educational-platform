package com.edpl.cms.web.exhandler.exceptions;

public class ApplicationBadRequest extends RuntimeException {
    public ApplicationBadRequest(String message) {
        super(message);
    }
}
