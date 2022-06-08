package com.auction.auctionservice.advisor;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice(basePackages = "com.auction")
public class AuctionAdvisor extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid
            (MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return new ResponseEntity<>(ErrorMessage.builder()
                .message(ex.getMessage())
                .error_code("BUS_1")
                .build(),status);
    }

    @ExceptionHandler(SystemException.class)
    protected ResponseEntity<ErrorMessage> handleSystemException(
            SystemException ex) {
       return new ResponseEntity<>(ErrorMessage.builder()
               .message(ex.getMessage())
               .error_code("SYS_100")
               .build(),HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(BusinessException.class)
    protected ResponseEntity<ErrorMessage> handleBusinessException(
            BusinessException ex) {
        return new ResponseEntity<>(ErrorMessage.builder()
                .message(ex.getMessage())
                .error_code("BUS_100")
                .build(),HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<ErrorMessage> handleGenericException(
            BusinessException ex) {
        return new ResponseEntity<>(ErrorMessage.builder()
                .message(ex.getMessage())
                .error_code("GENERIC_100")
                .build(),HttpStatus.BAD_REQUEST);
    }
}
