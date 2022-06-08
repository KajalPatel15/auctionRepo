package com.auction.auctionservice.component;

import com.auction.auctionservice.model.Item;
import com.auction.auctionservice.repository.AuctionJpaRepository;
import com.auction.auctionservice.repository.ItemJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@AllArgsConstructor
public class DataLoader {

    private ItemJpaRepository itemJpaRepository;

    //method invoked during the startup
    @PostConstruct
    public void loadData() {
        itemJpaRepository.save(new Item("1","Laptop"));
        itemJpaRepository.save(new Item("2","Desktop"));
        itemJpaRepository.save(new Item("3","Mobile"));
    }

    //method invoked during the shutdown
    @PreDestroy
    public void removeData() {
        itemJpaRepository.deleteAll();
    }
}
