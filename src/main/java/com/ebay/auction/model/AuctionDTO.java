package com.ebay.auction.model;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class AuctionDTO {

    private long id;
    private Date startTime;
    private Date endTime;
}
