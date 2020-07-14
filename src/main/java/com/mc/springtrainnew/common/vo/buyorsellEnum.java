package com.mc.springtrainnew.common.vo;

public enum buyorsellEnum {
    BUY(true), SELL(false);
    private Boolean buyorsell;

    buyorsellEnum(boolean buyorsell) {
        this.buyorsell = buyorsell;
    }

    public Boolean getBuyorsellCode() {
        return buyorsell;
    }
}
