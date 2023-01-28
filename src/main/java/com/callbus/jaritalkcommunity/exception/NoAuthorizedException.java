package com.callbus.jaritalkcommunity.exception;

public class NoAuthorizedException extends RuntimeException {

    @Override
    public String getMessage() {
        return "해당 경로로 접근할 수 없습니다";
    }
}
