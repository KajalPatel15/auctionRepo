package com.auction.auctionservice.domain.request;

import com.auction.auctionservice.domain.ItemDetails;
import com.sun.istack.NotNull;
import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.DecimalMin;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
public class AuctionRequest {

    @DecimalMin(value = "0.0", inclusive = false)
    public BigDecimal reservePrice;
    @Valid
    public ItemDetails item;

}
