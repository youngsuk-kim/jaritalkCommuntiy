package com.callbus.jaritalkcommunity.exception;

public class NoContentException extends RuntimeException{

    @Override
    public String getMessage() {
        return "글이 없습니다";
    }
}
