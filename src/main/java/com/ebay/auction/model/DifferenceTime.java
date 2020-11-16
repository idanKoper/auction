package com.ebay.auction.model;

import lombok.Data;

import java.util.Date;
import java.util.concurrent.TimeUnit;

@Data
public class DifferenceTime {

    private long differenceInTime;
    private long differenceInSeconds;
    private long differenceInMinutes;
    private long differenceInHours;
    private long differenceInDays;
    private long differenceInYears;


    public DifferenceTime(Date startTime, Date endTime) {

        this.differenceInTime = endTime.getTime() - startTime.getTime();
        this.differenceInSeconds = TimeUnit.MILLISECONDS.toSeconds(differenceInTime) % 60;
        this.differenceInMinutes = TimeUnit.MILLISECONDS.toMinutes(differenceInTime) % 60;
        this.differenceInHours = TimeUnit.MILLISECONDS.toHours(differenceInTime) % 365;
        this.differenceInDays = TimeUnit.MILLISECONDS.toDays(differenceInTime) % 365;
        this.differenceInYears = TimeUnit.MILLISECONDS.toDays(differenceInTime) / 365l;
    }

    public boolean isSameDay () {
        return differenceInYears < 1 && differenceInDays < 1;
    }

}
