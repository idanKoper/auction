package com.ebay.auction.repositories;

import com.ebay.auction.entities.Auction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface AuctionRepository extends JpaRepository<Auction,Long> {

        @Query("select a from Auction a where a.startTime > :date order by a.startTime asc")
        List<Auction> getNextAuctions(Date date);

}
