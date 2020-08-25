package com.lordgasmic.bff.models;

import lombok.Data;
import sun.tools.jconsole.Plotter;

@Data
public class FeedRequest {
    private String date;
    private String time;
    private Meridiem meridiem;
    private int given;
    private int quantity;
    private UnitOfMeasure givenUom;
    private UnitOfMeasure quantityUom;
    private boolean vitamin;
}
