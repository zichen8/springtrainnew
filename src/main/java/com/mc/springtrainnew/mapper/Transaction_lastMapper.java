package com.mc.springtrainnew.mapper;

import com.mc.springtrainnew.entity.Transaction_bid;
import com.mc.springtrainnew.entity.Transaction_last;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Eason+
 * @since 2020-07-14
 */
public interface Transaction_lastMapper extends BaseMapper<Transaction_last> {
    @Select(value="select * from transaction_last where tradeId=#{tradeId}")
    Transaction_last selectTranByTradeID(Integer tradeId);

    @Select(value="select * from transaction_last where securityCode=#{securityCode}")
    Transaction_last selectTranBySecurityCode(String securityCode);

}
