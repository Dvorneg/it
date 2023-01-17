package ru.inventarit.util.exception;

public class ErrorInfo {
    private final String url;
    private final ErrorType type;
    private final String typeMessage;
    private final String[] details;


    public ErrorInfo(CharSequence url, ErrorType type, String typeMessage, String... details) {
        this.url = url.toString();
        this.type = type;
        this.typeMessage = typeMessage;
        this.details = details;
    }

/*    public ErrorInfo(StringBuffer requestURL, ru.inventarit.util.exception.ErrorType errorType, String typeMessage, String[] strings) {
        this.url = requestURL.toString();
        this.type = errorType;
        this.typeMessage = typeMessage;
        this.details = strings;
    }*/

}
