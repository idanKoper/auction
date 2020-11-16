package com.ebay.auction.service;

import com.ebay.auction.entities.Auction;
import com.ebay.auction.repositories.AuctionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.source.InvalidConfigurationPropertyValueException;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AuctionServiceImpl implements AuctionService {

    @Autowired
    private AuctionRepository auctionRepository;


    @Override
    public Auction setAuction(long itemId, Date fromTime, Date toTime) {
        return auctionRepository.findById(itemId).map(auction -> {
            auction.setStartTime(fromTime);
            auction.setEndTime(toTime);
            return auctionRepository.save(auction);
        }).orElseGet(() -> auctionRepository.save(Auction.builder().id(itemId).startTime(fromTime).endTime(toTime).build()));
    }

    @Override
    public List<Auction> getNextAuction() {
        Date date = new Date();
        List<Auction> allAuctions =  auctionRepository.findAll();
        List<Auction> nextAuctions =  auctionRepository.getNextAuctions(date);
        return nextAuctions;
        //return nextAuctions.stream().filter(auction -> auction.getStartTime().after(date) && auction.getEndTime().before(date)).collect(Collectors.toList());
    }

    private List<Auction> nextAuctions(List<Auction> nextAuctions) {
       return null;
    }

}
