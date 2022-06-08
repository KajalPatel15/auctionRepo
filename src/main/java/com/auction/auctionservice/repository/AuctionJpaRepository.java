package com.auction.auctionservice.repository;

import com.auction.auctionservice.model.AuctionRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuctionJpaRepository extends JpaRepository<AuctionRecord, Long> {

    @Override
    Optional<AuctionRecord> findById(Long aLong);
}
