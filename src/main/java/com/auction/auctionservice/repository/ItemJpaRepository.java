package com.auction.auctionservice.repository;

import com.auction.auctionservice.model.AuctionRecord;
import com.auction.auctionservice.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ItemJpaRepository extends JpaRepository<Item, String> {

    @Override
    Optional<Item> findById(String id);
}
