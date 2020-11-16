package com.ebay.auction.service;

import com.ebay.auction.entities.Auction;

import java.util.Date;
import java.util.List;

public interface AuctionService {

    Auction setAuction (long itemId, Date  fromTime, Date toTime);

    List<Auction> getNextAuction();

}
