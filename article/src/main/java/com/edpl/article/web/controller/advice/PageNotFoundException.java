package com.edpl.article.web.controller.advice;

/**
 * @author ogbozoyan
 * @date 08.03.2023
 */
public class PageNotFoundException extends AbstractException {
    public PageNotFoundException(String msg) {
        super(msg);
    }
}
