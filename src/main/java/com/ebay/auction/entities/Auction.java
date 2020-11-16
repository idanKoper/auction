package com.ebay.auction.entities;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Data
@Builder
@Validated
@NoArgsConstructor
@AllArgsConstructor
public class Auction {

    @Id
    private long id;

    @NotNull(message = "Start time is required")
    @Temporal(TemporalType.DATE)
    //@Column(unique=true)
    @DateTimeFormat(pattern="dd-MM-yyyy HH:mm:ss")
    private Date startTime;

    @NotNull(message = "End time is required")
    @Temporal(TemporalType.DATE)
    //@Column(unique=true)
    @DateTimeFormat(pattern="dd-MM-yyyy HH:mm:ss")
    private Date endTime;
}
