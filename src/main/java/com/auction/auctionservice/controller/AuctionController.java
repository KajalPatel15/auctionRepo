
package com.auction.auctionservice.controller;

import com.auction.auctionservice.domain.reponse.AuctionResponse;
import com.auction.auctionservice.domain.request.AuctionRequest;
import com.auction.auctionservice.model.Item;
import com.auction.auctionservice.repository.ItemJpaRepository;
import com.auction.auctionservice.service.AuctionService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController("/auction")
@AllArgsConstructor
public class AuctionController {

    AuctionService auctionService;
    ItemJpaRepository itemJpaRepository;

    @PostMapping("/auction-items")
    public AuctionResponse reserveAuction(@Valid @RequestBody AuctionRequest auctionRequest){
        return auctionService.processAuction(auctionRequest);
    }

    @GetMapping("/products")
    public List<Item> getAllProducts(){
        return itemJpaRepository.findAll();
    }
}
