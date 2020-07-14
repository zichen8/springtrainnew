package com.mc.springtrainnew.entity;

import java.io.Serializable;
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
public class Transaction_last implements Serializable {

    private static final long serialVersionUID=1L;

    private Integer tradeid;

    private String securitycode;

    private Integer quantity;

    private Long accountid;
}
