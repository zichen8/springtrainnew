package com.mc.springtrainnew.entity;

import java.time.LocalDateTime;
import java.io.Serializable;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 *
 * </p>
 *
 * @author Eason+
 * @since 2020-07-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Transaction_bid implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "transactionid", type = IdType.AUTO)
    private Integer transactionid;

    private Integer tradeid;

    private String securitycode;

    private Integer insertorupdateorcancel;

    @JSONField(serializeUsing = ToStringSerializer.class)
    private Long accountid;

    private Boolean buyorsell;

    private Integer quantity;

}
