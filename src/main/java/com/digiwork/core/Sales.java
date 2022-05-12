package com.digiwork.core;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Sales{

    private String orderID;
    private String orderDate;
    private String city;
    private String state;
    private String type;
    private double units;
    private double unitCost;
    private double total;
}