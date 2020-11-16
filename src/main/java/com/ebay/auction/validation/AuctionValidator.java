package com.ebay.auction.validation;

import com.ebay.auction.entities.Auction;
import com.ebay.auction.model.DifferenceTime;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class AuctionValidator {

    public static final int THREE_HOURS = 3;
    public static final int Fifteen_Minutes = 15;


    public boolean isAuctionValidDate(Date startTime, Date endTime) {
        DifferenceTime differenceTime = new DifferenceTime(startTime, endTime);
        if (differenceTime.isSameDay()
                && (validateDateLessThenThreeHours(differenceTime)
                && validateDateMoreThenFifteenMinutes(differenceTime)))
            return true;
        else {
            throw new IllegalArgumentException("Illegal Dates");
        }
    }

    public boolean isAuctionOccurThisDay(List<Auction> auctions) {
        return auctions.size() < 8;
    }

    private boolean validateDateLessThenThreeHours(DifferenceTime differenceTime) {
        return differenceTime.getDifferenceInHours() <= THREE_HOURS;
    }

    private boolean validateDateMoreThenFifteenMinutes(DifferenceTime differenceTime) {
        return differenceTime.getDifferenceInMinutes() >= Fifteen_Minutes;
    }


}
