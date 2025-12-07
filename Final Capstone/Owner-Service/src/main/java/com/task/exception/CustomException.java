package com.task.exception;

public class CustomException extends RuntimeException {
    public CustomException(String message) {
        super(message);
    }
}

class UserNotFoundException extends CustomException {
    public UserNotFoundException(String message) {
        super(message);
    }
}

class DuplicateUserException extends CustomException {
    public DuplicateUserException(String message) {
        super(message);
    }
}

class InvalidCredentialsException extends CustomException {
    public InvalidCredentialsException(String message) {
        super(message);
    }
}

class ReviewNotFoundException extends CustomException {
    public ReviewNotFoundException(String message) {
        super(message);
    }
}