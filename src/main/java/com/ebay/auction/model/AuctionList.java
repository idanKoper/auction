package com.ebay.auction.model;


import com.ebay.auction.entities.Auction;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
//Need to convert to AuctionListDTO
public class AuctionList {

    private List<Auction> auctions;
}
