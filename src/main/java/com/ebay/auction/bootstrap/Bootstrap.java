package com.ebay.auction.bootstrap;

import com.ebay.auction.repositories.AuctionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements CommandLineRunner {

    private AuctionRepository auctionRepository;

    public Bootstrap(AuctionRepository auctionRepository) {
        this.auctionRepository = auctionRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        //loadAuction();
    }

//    private void loadAuction() {
//        Auction auction1 = Auction.builder()
//                .endTime(new Date())
//                .startTime(new Date())
//                .id(0).build();
//        auctionRepository.save(auction1);
//
//        Auction auction2 = Auction.builder()
//                .endTime(new Date())
//                .startTime(new Date())
//                .id(0).build();
//        auctionRepository.save(auction2);

//        System.out.println("Data Loaded = " + auctionRepository.count());
//    }
}
