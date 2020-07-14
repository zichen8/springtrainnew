package com.mc.springtrainnew.entity;

import lombok.Data;

@Data
public class InsertModel {
    private Integer tradeID;
    private Integer quantity;
    private Boolean buyorsell;
    private Integer iuc;
    private String securitycode;
}
