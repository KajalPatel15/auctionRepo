package com.auction.auctionservice.domain.reponse;

import com.auction.auctionservice.domain.ItemDetails;
import com.auction.auctionservice.domain.request.AuctionRequest;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
public class AuctionResponse extends AuctionRequest {

    private String auctionItemUuid;

    @Builder
    public AuctionResponse(BigDecimal reservePrice, ItemDetails itemDetails, String auctionItemUuid) {
        super(reservePrice, itemDetails);
       this.auctionItemUuid=auctionItemUuid;
    }


}
