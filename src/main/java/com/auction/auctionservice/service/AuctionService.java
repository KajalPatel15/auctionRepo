package com.auction.auctionservice.service;

import com.auction.auctionservice.advisor.BusinessException;
import com.auction.auctionservice.advisor.SystemException;
import com.auction.auctionservice.domain.reponse.AuctionResponse;
import com.auction.auctionservice.domain.request.AuctionRequest;
import com.auction.auctionservice.model.AuctionRecord;
import com.auction.auctionservice.model.Item;
import com.auction.auctionservice.repository.AuctionJpaRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class AuctionService {

    AuctionJpaRepository auctionJpaRepository;

    public AuctionResponse processAuction(AuctionRequest auctionRequest) {

        AuctionRecord auctionRecord = new AuctionRecord();
        Item item = new Item();
        item.setItemId(auctionRequest.getItem().getItemId());
        auctionRecord.setDescription(auctionRequest.getItem().getDescription());
        auctionRecord.setItem(item);
        auctionRecord.setReservePrice(auctionRequest.getReservePrice());
        AuctionRecord persistedRecord =  null;
        try{
             persistedRecord  = auctionJpaRepository.saveAndFlush(auctionRecord);
        }catch (Exception e){
            log.error("Error in Process Auction",e);
            if(e instanceof InvalidDataAccessApiUsageException){
                throw new BusinessException("Data Integrity Failed",e);
            }
            throw new SystemException("Error persisting Data:"+e.getCause(),e);
        }

        return AuctionResponse
                .builder()
                .auctionItemUuid(String.valueOf(persistedRecord.getId()))
                .itemDetails(auctionRequest.getItem())
                .reservePrice(auctionRequest.getReservePrice())
                .build();

    }
}
