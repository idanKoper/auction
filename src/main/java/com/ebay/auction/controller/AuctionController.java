package com.ebay.auction.controller;

import com.ebay.auction.entities.Auction;
import com.ebay.auction.model.AuctionList;
import com.ebay.auction.service.AuctionServiceImpl;
import com.ebay.auction.validation.AuctionValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.source.InvalidConfigurationPropertyValueException;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/api/v1/auctions")
public class AuctionController {

    @Autowired
    AuctionServiceImpl auctionService;

    @Autowired
    AuctionValidator auctionValidator;


    @PutMapping
    public Auction updateAuction(@RequestParam(name = "itemId", required = true) Long itemId,
                                 @RequestParam(name = "fromTime", required = true) @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm:ss") Date fromTime,
                                 @RequestParam(name = "toTime", required = true) @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm:ss") Date toTime) throws InvalidConfigurationPropertyValueException {
        auctionValidator.isAuctionValidDate(fromTime, toTime);
        return auctionService.setAuction(itemId, fromTime, toTime);
    }

    @GetMapping
    public ResponseEntity<AuctionList> getNextAuction() throws InvalidConfigurationPropertyValueException {
        return new ResponseEntity<>(new AuctionList(auctionService.getNextAuction()), HttpStatus.OK);
    }


}
