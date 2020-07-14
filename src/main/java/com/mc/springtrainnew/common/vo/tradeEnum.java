package com.mc.springtrainnew.common.vo;

public enum tradeEnum {
    First(1), Second(2), Third(3), Fouth(4);

    private tradeEnum(int tradeID) {
        this.tradeID = tradeID;
    }

    private final Integer tradeID;


    public Integer getTradeID() {
        return tradeID;
    }
}
