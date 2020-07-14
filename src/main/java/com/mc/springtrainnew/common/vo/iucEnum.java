package com.mc.springtrainnew.common.vo;

public enum iucEnum {
    Insert(1),Update(2),Cancel(3);
    private Integer iucCode;

    iucEnum(Integer iucCode) {
        this.iucCode=iucCode;
    }

    public Integer getIucCode() {
        return iucCode;
    }
}
