package com.epam.paper.exceptions;

public class XmlParserException extends Exception {
    public XmlParserException(String message, Throwable cause) {
        super(message, cause);
    }

    public XmlParserException(String message) {
        super(message);
    }

    public XmlParserException() {
    }
}
