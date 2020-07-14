package com.mc.springtrainnew.common.vo;

public enum securityCodeEnum {

    REL("REL"), ITC("ITC"), INF("INF ");

    private securityCodeEnum(String securityCode) {
        this.securityCode = securityCode;
    }

    private final String securityCode;

    public String getSecurityCode() {
        return securityCode;
    }
}
