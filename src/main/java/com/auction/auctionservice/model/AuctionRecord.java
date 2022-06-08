package com.auction.auctionservice.model;


import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="AuctionRecords")
@Data
public class AuctionRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "reservePrice")
    private BigDecimal reservePrice;

    @Column(name = "description")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "itemId", nullable = false)
    Item item;




}
