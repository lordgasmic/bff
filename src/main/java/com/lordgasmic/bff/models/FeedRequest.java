package com.lordgasmic.bff.models;

import lombok.Data;

@Data
public class FeedRequest {
    private String date;
    private int timeHour;
    private int timeMinute;
    private Meridiem meridiem;
    private int given;
    private int quantity;
    private UnitOfMeasure givenUom;
    private UnitOfMeasure quantityUom;
    private boolean vitamin;
    private String note;
}
