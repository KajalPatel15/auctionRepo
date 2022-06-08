package com.auction.auctionservice.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="Item")
@AllArgsConstructor
@NoArgsConstructor
public class Item {

    @Getter
    @Setter
    @Id
    String itemId;
    @Getter
    String name;
}
