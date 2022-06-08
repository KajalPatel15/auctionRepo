package com.auction.auctionservice.advisor;

public class BusinessException extends RuntimeException {

    public BusinessException(String message, Throwable throwable) {
        super(message,
                throwable);
    }
}
