package com.auction.auctionservice.advisor;

public class SystemException extends RuntimeException {

    public SystemException(String message,Throwable throwable) {
        super(message,
                throwable);
    }
}
