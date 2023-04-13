package com.erkan.HouseService.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Data
public class House {
    @Id
    private String id;
    private Date createDate = new Date();
    private String name;
    private int price;
    private String HouseType;
    private String AreaInSqFt;
    private String Bedrooms;
    private String Bathrooms;
    private String Receptions;
    private String Location;
    private String City;
    private String PostalCode;

}
