package com.auction.auctionservice.domain;


import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class ItemDetails {

    @NotEmpty
    public String itemId;
    @NotEmpty
    public String description;
}
